package in.foxlogic.gsmswitch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import in.foxlogic.gsmswitch.customexception.AuthenticationException;
import in.foxlogic.gsmswitch.customexception.DeviceNotRegisteredException;
import in.foxlogic.gsmswitch.customexception.InvalidSerialNumberException;
import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;
import in.foxlogic.gsmswitch.dto.ServerRelayDetailsRequestDto;
import in.foxlogic.gsmswitch.service.DeviceService;
import in.foxlogic.gsmswitch.util.StringConstants;

@RestController
public class DeviceRestController {
	@Autowired
	private DeviceService deviceService;

	@PostMapping("/relay-handler")
	public String operateRelay(@SessionAttribute("deviceSessionDetails") DeviceSessionDetails deviceSessionDetails) {
		boolean relayNewStatus = deviceService.operateSwitch(deviceSessionDetails);
		String responseColor = relayNewStatus ? StringConstants.BOOTSTRAP_BOTTON_COLOR_SECCESS
				: StringConstants.BOOTSTRAP_BOTTON_COLOR_DEFAULT;
		return responseColor;
	}

	@PostMapping("/fetch-commands")
	public String sendServerSideRelayDetails(
			@Valid ServerRelayDetailsRequestDto serverRelayDetailsRequestDto)
			throws InvalidSerialNumberException, DeviceNotRegisteredException, AuthenticationException {
		return deviceService.sendServerSideRelayDetails(serverRelayDetailsRequestDto);

	}
	
}
