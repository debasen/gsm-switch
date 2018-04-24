package in.foxlogic.gsmswitch.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;
import in.foxlogic.gsmswitch.dto.UserRegistrationDto;
import in.foxlogic.gsmswitch.dto.UserSessionDetails;
import in.foxlogic.gsmswitch.model.Device;
import in.foxlogic.gsmswitch.model.User;
import in.foxlogic.gsmswitch.service.UserService;
import in.foxlogic.gsmswitch.util.RelayUtil;

@SessionAttributes({ "userSessionDetails", "deviceSessionDetails" })
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping({ "/welcome", "/" })
	public String displayWelcomePage() {
		return "welcome";
	}

	@GetMapping("/dashboard")
	public ModelAndView displayDashboard() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String emailId = auth.getName();
		UserSessionDetails userSessionDetails = new UserSessionDetails();
		DeviceSessionDetails deviceSessionDetails = new DeviceSessionDetails();
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.findUserById(emailId);
		Device device = user.getDevice();
		if (device == null) {
			modelAndView.addObject("noDevice", true);
		} else {
			BeanUtils.copyProperties(device, deviceSessionDetails);
			deviceSessionDetails.setUserEmailId(emailId);
			modelAndView.addObject("deviceSessionDetails", deviceSessionDetails);
			modelAndView.addObject("relayColor", RelayUtil.getColorValue(deviceSessionDetails));
		}
		BeanUtils.copyProperties(user, userSessionDetails);
		modelAndView.addObject("userSessionDetails", userSessionDetails);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "Invalid username or password!");
		}
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@GetMapping("/sign-up")
	public String displaySignUpPage(UserRegistrationDto userRegistrationDto) {
		return "sign-up";
	}

	@PostMapping("/sign-up-processor")
	public ModelAndView registerUser(@Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("sign-up", "userRegistrationDto", userRegistrationDto);
		}
		User newUser = new User();
		BeanUtils.copyProperties(userRegistrationDto, newUser);
		User savedUser = userService.registerUser(newUser);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("emailId", savedUser.getEmailId());
		modelAndView.addObject("registrationComplete", "success");
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@PostMapping("/forgot-password-processor")
	public ModelAndView processForgotPassword(@RequestParam("forgotPassEmailId") String emailId) {
		boolean isReset = userService.processForgotPassword(emailId);
		String forgotPasswordMessage = isReset ? "Password Sent. Please check your email id for new password."
				: "No account exist with email id: " + emailId;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("isReset", isReset);
		modelAndView.addObject("forgotPasswordMessage", forgotPasswordMessage);
		modelAndView.setViewName("welcome");
		return modelAndView;
	}
}
