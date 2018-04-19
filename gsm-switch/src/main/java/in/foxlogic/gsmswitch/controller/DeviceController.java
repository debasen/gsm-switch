package in.foxlogic.gsmswitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import in.foxlogic.gsmswitch.dto.UserSessionDetails;
import in.foxlogic.gsmswitch.service.DeviceService;
import in.foxlogic.gsmswitch.util.StringConstants;

@Controller
public class DeviceController {
	@Autowired
	DeviceService deviceService;

	@PostMapping("/device-registration")
	public ModelAndView registerDevice(@SessionAttribute UserSessionDetails userSessionDetails,
			@RequestParam("deviceSerialNo") String deviceSerialNo) {
		String response = deviceService.registerDevice(userSessionDetails.getEmailId(), deviceSerialNo);
		if (StringConstants.DEVICE_SUCCESSFULLY_REGISTERED.equals(response)) {
			return new ModelAndView("redirect:/dashboard");
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("noDevice", true);
		modelAndView.setViewName("dashboard");
		modelAndView.addObject("registraionStatus", response);
		return modelAndView;
	}
}
