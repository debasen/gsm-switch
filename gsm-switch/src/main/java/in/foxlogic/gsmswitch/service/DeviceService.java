package in.foxlogic.gsmswitch.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.foxlogic.gsmswitch.dao.DeviceRepository;
import in.foxlogic.gsmswitch.dao.UserRepository;
import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;
import in.foxlogic.gsmswitch.model.Device;
import in.foxlogic.gsmswitch.model.User;
import in.foxlogic.gsmswitch.util.StringConstants;

@Service
public class DeviceService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	DeviceRepository deviceRepository;

	public Device getDeviceOfUser(String userName) {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("No user exists with User Name: " + userName);
		}
		return user.getDevice();
	}

	public boolean operateSwitch(DeviceSessionDetails deviceSessionDetails, String relayId) {
		boolean relayNewStatus = false;
		Device device = deviceRepository.findBySerialNumber(deviceSessionDetails.getSerialNumber());
		switch (relayId) {
		case StringConstants.RELAY_BEAN_ID1:
			device.setRelay1(relayNewStatus = !deviceSessionDetails.isRelay1());
			break;
		case StringConstants.RELAY_BEAN_ID2:
			device.setRelay2(relayNewStatus = !deviceSessionDetails.isRelay2());
			break;
		case StringConstants.RELAY_BEAN_ID3:
			device.setRelay3(relayNewStatus = !deviceSessionDetails.isRelay3());
			break;
		case StringConstants.RELAY_BEAN_ID4:
			device.setRelay4(relayNewStatus = !deviceSessionDetails.isRelay4());
			break;
		default:
			break;
		}
		deviceRepository.save(device);
		BeanUtils.copyProperties(device, deviceSessionDetails);
		return relayNewStatus;
	}

	public String registerDevice(String emailId, Long deviceSerialNo) {
		Device device = deviceRepository.findBySerialNumber(deviceSerialNo);
		if (device == null) {
			return StringConstants.INVALID_SERIAL_NO;
		} else if (device.getUser() != null) {
			return StringConstants.DEVICE_ALREADY_REGISTERED;
		} else {
			device.setUser(userRepository.findOne(emailId));
			deviceRepository.save(device);
			return StringConstants.DEVICE_SUCCESSFULLY_REGISTERED;
		}
	}

}