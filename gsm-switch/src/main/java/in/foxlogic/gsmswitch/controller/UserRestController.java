package in.foxlogic.gsmswitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.foxlogic.gsmswitch.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	UserService userService;

	@PostMapping("/check-for-existing-email")
	public String checkForExistingEmail(@RequestParam(name = "emailId", required = true) String emailId) {
		String response = userService.checkForExistingEmail(emailId);
		return response;
	}

	@PostMapping("/check-for-existing-userName")
	public String checkForExistingUserName(@RequestParam(name = "userName", required = true) String userName) {
		String response = userService.checkForExistingUserName(userName);
		return response;
	}

}
