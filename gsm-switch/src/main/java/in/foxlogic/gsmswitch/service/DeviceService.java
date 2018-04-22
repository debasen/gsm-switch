package in.foxlogic.gsmswitch.service;

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
import in.foxlogic.gsmswitch.dto.ServerRelayDetailsRequestDto;
import in.foxlogic.gsmswitch.model.Device;
import in.foxlogic.gsmswitch.model.User;
import in.foxlogic.gsmswitch.util.StringConstants;

@Service
public class DeviceService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	UserService userService;

	public Device getDeviceOfUser(String userName) {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("No user exists with User Name: " + userName);
		}
		return user.getDevice();
	}

	public boolean operateSwitch(DeviceSessionDetails deviceSessionDetails) {
		boolean relayNewStatus = false;
		Device device = deviceRepository.findBySerialNumber(deviceSessionDetails.getSerialNumber());
		device.setRelay(relayNewStatus = !deviceSessionDetails.isRelay());
		deviceRepository.save(device);
		BeanUtils.copyProperties(device, deviceSessionDetails);
		return relayNewStatus;
	}

	public String registerDevice(String emailId, String deviceSerialNoString) {
		Long deviceSerialNo;
		try {
			deviceSerialNo = Long.parseLong(deviceSerialNoString);
		} catch (NumberFormatException e) {
			return StringConstants.INVALID_SERIAL_NO; // If a non numeric serial number is received from user
		}
		Device device = deviceRepository.findBySerialNumber(deviceSerialNo);
		if (device == null) {
			return StringConstants.INVALID_SERIAL_NO;
		} else if (device.getUser() != null) {
			return StringConstants.DEVICE_ALREADY_REGISTERED;
		} else {
			User user = userRepository.findOne(emailId);
			device.setUser(user);
			userService.setSecurityKey(device);
			deviceRepository.save(device);
			return StringConstants.DEVICE_SUCCESSFULLY_REGISTERED;
		}
	}

	public String sendServerSideRelayDetails(ServerRelayDetailsRequestDto serverRelayDetailsRequestDto)
			throws InvalidSerialNumberException, DeviceNotRegisteredException, AuthenticationException {
		Long serialNumber = serverRelayDetailsRequestDto.getSerialNumber();
		String securityKey = serverRelayDetailsRequestDto.getSecurityKey();
		int iterationIndex = serverRelayDetailsRequestDto.getIterationIndex();
		Device device = deviceRepository.findBySerialNumber(serialNumber);
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
		// If everything goes well
		else {
			String relayStatus = device.isRelay() ? "On" : "Off";
			int registerAddress = device.getSensorList().get(iterationIndex).getAddress();
			String response = "<" + relayStatus + "," + registerAddress+">";
			return response;
		}
	}

}
