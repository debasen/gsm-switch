package in.foxlogic.gsmswitch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import in.foxlogic.gsmswitch.customexception.AuthenticationException;
import in.foxlogic.gsmswitch.customexception.DeviceIterationException;
import in.foxlogic.gsmswitch.customexception.DeviceNotRegisteredException;
import in.foxlogic.gsmswitch.customexception.InvalidSerialNumberException;
import in.foxlogic.gsmswitch.dto.DeviceStatusRequestDto;
import in.foxlogic.gsmswitch.dto.PollServerResponse;
import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;
import in.foxlogic.gsmswitch.dto.RelayOperationResponse;
import in.foxlogic.gsmswitch.dto.ServerRelayDetailsRequestDto;
import in.foxlogic.gsmswitch.service.DeviceService;
import in.foxlogic.gsmswitch.util.RelayUtil;

@RestController
public class DeviceRestController {
	@Autowired
	private DeviceService deviceService;

	@PostMapping("/operate-relay")
	public RelayOperationResponse operateRelay(
			@SessionAttribute("deviceSessionDetails") DeviceSessionDetails deviceSessionDetails, boolean relayState) {
		deviceService.operateSwitch(deviceSessionDetails, relayState);
		String responseColor = RelayUtil.getColorValue(deviceSessionDetails);
		RelayOperationResponse relayOperationResponse = new RelayOperationResponse();
		relayOperationResponse.setButtonColor(responseColor);
		relayOperationResponse.setRelayStatus(deviceSessionDetails.isRelay());
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return relayOperationResponse;
	}

	@PostMapping("/ftchCmnds")
	public String sendServerSideRelayDetails(@Valid ServerRelayDetailsRequestDto serverRelayDetailsRequestDto)
			throws InvalidSerialNumberException, DeviceNotRegisteredException, AuthenticationException,
			DeviceIterationException {
		return deviceService.sendServerSideRelayDetails(serverRelayDetailsRequestDto);

	}

	@PostMapping("/putStats")
	public String getDeviceSideRelayDetails(@Valid DeviceStatusRequestDto deviceStatusRequestDto)
			throws InvalidSerialNumberException, DeviceNotRegisteredException, AuthenticationException {
		return deviceService.getDeviceStatus(deviceStatusRequestDto);

	}

	@GetMapping("/poll-server")
	public PollServerResponse pollServer(
			@SessionAttribute("deviceSessionDetails") DeviceSessionDetails deviceSessionDetails) {
		return deviceService.pollServer(deviceSessionDetails);

	}

}
