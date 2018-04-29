package in.foxlogic.gsmswitch.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.foxlogic.gsmswitch.customexception.AuthenticationException;
import in.foxlogic.gsmswitch.customexception.DeviceNotRegisteredException;
import in.foxlogic.gsmswitch.customexception.InvalidSerialNumberException;
import in.foxlogic.gsmswitch.dao.DeviceRepository;
import in.foxlogic.gsmswitch.dao.UserRepository;
import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;
import in.foxlogic.gsmswitch.dto.DeviceStatusRequestDto;
import in.foxlogic.gsmswitch.dto.ServerRelayDetailsRequestDto;
import in.foxlogic.gsmswitch.model.Device;
import in.foxlogic.gsmswitch.model.Sensor;
import in.foxlogic.gsmswitch.model.StatusHistory;
import in.foxlogic.gsmswitch.model.User;
import in.foxlogic.gsmswitch.util.Constants;
import in.foxlogic.gsmswitch.util.RelayUtil;

@Service
public class DeviceService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	UserService userService;

	@Autowired
	List<Integer> sensorAddressList;

	@Autowired
	Map<Integer, String> sensorMap;

	public Device getDefaultDeviceOfUser(String userName) {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("No user exists with User Name: " + userName);
		}
		return user.getDefaultDevice();
	}

	public List<Device> getDevicesOfUser(String userName) {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("No user exists with User Name: " + userName);
		}
		return user.getDevices();
	}

	public boolean operateSwitch(DeviceSessionDetails deviceSessionDetails, boolean relayState) {
		boolean relayNewStatus = relayState;
		Device device = deviceRepository.findBySerialNumber(deviceSessionDetails.getSerialNumber());
		device.setRelay(relayNewStatus);
		deviceRepository.save(device);
		BeanUtils.copyProperties(device, deviceSessionDetails);
		return relayNewStatus;
	}

	public String registerDevice(String emailId, String deviceSerialNoString) {
		Long deviceSerialNo;
		try {
			deviceSerialNo = Long.parseLong(deviceSerialNoString);
		} catch (NumberFormatException e) {
			return Constants.INVALID_SERIAL_NO; // If a non numeric serial number is received from user
		}
		Device device = deviceRepository.findBySerialNumber(deviceSerialNo);
		if (device == null) {
			return Constants.INVALID_SERIAL_NO;
		} else if (device.getUser() != null) {
			return Constants.DEVICE_ALREADY_REGISTERED;
		} else {
			User user = userRepository.findOne(emailId);
			device.setUser(user);
			userService.setSecurityKey(device);
			device.getUser().setDefaultDevice(device);
			deviceRepository.save(device);
			return Constants.DEVICE_SUCCESSFULLY_REGISTERED;
		}
	}

	public String sendServerSideRelayDetails(ServerRelayDetailsRequestDto serverRelayDetailsRequestDto)
			throws InvalidSerialNumberException, DeviceNotRegisteredException, AuthenticationException {
		Long serialNumber = serverRelayDetailsRequestDto.getsNo();
		String securityKey = serverRelayDetailsRequestDto.getSecKy();
		int iterationIndex = serverRelayDetailsRequestDto.getlIndx();
		Device device = deviceRepository.findBySerialNumber(serialNumber);
		authenticateDevice(serialNumber, securityKey, device);
		String relayStatus = device.isRelay() ? "On" : "Off";
		int registerAddress = sensorAddressList.get(iterationIndex);
		String response = "<" + relayStatus + "," + registerAddress + ">";
		return response;
	}

	public String getDeviceStatus(DeviceStatusRequestDto deviceStatusRequestDto)
			throws InvalidSerialNumberException, DeviceNotRegisteredException, AuthenticationException {
		Long serialNumber = deviceStatusRequestDto.getsNo();
		String securityKey = deviceStatusRequestDto.getSecKy();
		Device device = deviceRepository.findBySerialNumber(serialNumber);
		authenticateDevice(serialNumber, securityKey, device);
		device.setDeviceRelay(deviceStatusRequestDto.isRly());
		device.setDeviceFeedbackRelay(deviceStatusRequestDto.isFrly());
		device.setLastConnected(LocalDateTime.now(ZoneId.of(Constants.CALCUTTA_TIME_ZONE)).toString());
		String sensorType = sensorMap.get(sensorAddressList.get(deviceStatusRequestDto.getlIndx()));
		String sensorValue = RelayUtil.convertSensorRawData(sensorType, deviceStatusRequestDto.getsVlu());
		Sensor sensor = device.getSensors() == null ? new Sensor() : device.getSensors();
		switch (sensorType) {
		case Constants.OPERATING_FREQUENCY:
			sensor.setOperatingFrequency(sensorValue);
			break;
		case Constants.OPERATING_CURRENT:
			sensor.setOperatingCurrent(sensorValue);
			break;
		case Constants.DC_VOLTAGE:
			sensor.setDcVoltage(sensorValue);
			break;
		case Constants.AC_VOLTAGE:
			sensor.setAcVoltage(sensorValue);
			break;
		case Constants.IGBT_TEMPERATURE:
			sensor.setIgbtTemperature(sensorValue);
			break;
		}
		device.setSensors(sensor);
		// Last iteration
		if (deviceStatusRequestDto.getlIndx() == sensorAddressList.size() - 1) {
			StatusHistory statusHistory = new StatusHistory();
			BeanUtils.copyProperties(device.getSensors(), statusHistory);
			statusHistory.setTime(LocalDateTime.now(ZoneId.of(Constants.CALCUTTA_TIME_ZONE)).toString());
			device.getStatusHistory().add(statusHistory);
		}
		deviceRepository.save(device);
		return "SAVED";
	}

	public void authenticateDevice(Long serialNumber, String securityKey, Device device)
			throws InvalidSerialNumberException, DeviceNotRegisteredException, AuthenticationException {
		// If no device exist with the serial number
		if (device == null) {
			throw new InvalidSerialNumberException("Invalid Serial Number");
		}
		// If security key is blank. i.e., not registered to any user yet
		else if (StringUtils.isBlank(device.getSecurityKey())) {
			throw new DeviceNotRegisteredException("The device is not registered to any user.");
		}
		// If security key does not match
		else if (!device.getSecurityKey().equals(securityKey)) {
			throw new AuthenticationException("Security Key does not match. Contact Admin.");

		}
	}

	public void fetchDeviceStatus(DeviceSessionDetails deviceSessionDetails) {
		Long deviceId = deviceSessionDetails.getDeviceId();
		Device device = deviceRepository.getOne(deviceId);
		BeanUtils.copyProperties(device, deviceSessionDetails);

		if (device.getLastConnected() != null) {
			LocalDateTime lastConnected = LocalDateTime.parse(device.getLastConnected());
			deviceSessionDetails.setLastConnectedDate(lastConnected.toLocalDate().toString());
			deviceSessionDetails.setLastConnectedTime(lastConnected.toLocalTime().toString());
			LocalDateTime now = LocalDateTime.now(ZoneId.of(Constants.CALCUTTA_TIME_ZONE));
			deviceSessionDetails.setNotReachable(lastConnected.until(now, ChronoUnit.MINUTES) > 15);
		}
		String relayColor = RelayUtil.getColorValue(deviceSessionDetails);
		deviceSessionDetails.setRelayColor(relayColor);
	}

}
