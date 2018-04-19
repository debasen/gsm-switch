package in.foxlogic.gsmswitch.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import in.foxlogic.gsmswitch.customexception.AuthenticationException;
import in.foxlogic.gsmswitch.customexception.DeviceNotRegisteredException;
import in.foxlogic.gsmswitch.customexception.InvalidSerialNumberException;
import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;
import in.foxlogic.gsmswitch.dto.ServerRelayDetailsRequestDto;
import in.foxlogic.gsmswitch.dto.ServerRelayDetailsResponseDto;
import in.foxlogic.gsmswitch.service.DeviceService;
import in.foxlogic.gsmswitch.util.StringConstants;

@RestController
public class DeviceRestController {
	@Autowired
	private DeviceService deviceService;

	@Autowired
	private Map<String, String> relayIdMap;

	@PostMapping("/relay-handler")
	public String operateRelay(@SessionAttribute("deviceSessionDetails") DeviceSessionDetails deviceSessionDetails,
			@RequestParam("relay-id") String relayId) {
		boolean relayNewStatus = deviceService.operateSwitch(deviceSessionDetails, relayIdMap.get(relayId));
		String responseColor = relayNewStatus ? StringConstants.BOOTSTRAP_BOTTON_COLOR_SECCESS
				: StringConstants.BOOTSTRAP_BOTTON_COLOR_DEFAULT;
		return responseColor;
	}

	@PostMapping("/server-relay-state")
	public ServerRelayDetailsResponseDto sendServerSideRelayDetails(
			@Valid ServerRelayDetailsRequestDto serverRelayDetailsRequestDto)
			throws InvalidSerialNumberException, DeviceNotRegisteredException, AuthenticationException {
		Long serialNumber;
		try {
			serialNumber = Long.parseLong(serverRelayDetailsRequestDto.getSerialNumber());
		} catch (NumberFormatException e) {
			throw new InvalidSerialNumberException("The serial number is not valid");
		}
		ServerRelayDetailsResponseDto serverRelayDetailsResponseDto = deviceService
				.sendServerSideRelayDetails(serialNumber, serverRelayDetailsRequestDto.getSecurityKey());

		return serverRelayDetailsResponseDto;

	}

}
