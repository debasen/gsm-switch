package in.foxlogic.gsmswitch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.foxlogic.gsmswitch.dao.DeviceRepository;
import in.foxlogic.gsmswitch.dao.UserRepository;
import in.foxlogic.gsmswitch.model.Device;
import in.foxlogic.gsmswitch.model.User;
import in.foxlogic.gsmswitch.util.PasswordUtil;
import in.foxlogic.gsmswitch.util.SecurityUtil;
import in.foxlogic.gsmswitch.util.Constants;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DeviceRepository deviceRepository;
	@Autowired
	EmailService emailService;

	public User findUserById(String emailId) {
		return userRepository.findOne(emailId);
	}

	public User registerUser(User newUser) {
		// if (userRepository.findOne(newUser.getEmailId()) != null) {
		// throw new UserAlreayExistsException("Email id already exists.");
		// }
		// if (userRepository.findByUserName(newUser.getUserName()) != null) {
		// throw new UserAlreayExistsException("Username already exists.");
		// }
		String newPassword = PasswordUtil.generatePassword();
		newUser.setPassword(newPassword);
		newUser.setRole("ROLE_USER");
		newUser.setActive(true);
		User savedUser = userRepository.save(newUser);
		String message = "<html><body><h1>Welcome " + newUser.getFirstName()
				+ "</h1></br></br><p>Your account is created successfully. Please use the following credential to Login:</p></br></br>"
				+ "<p><b>Email: </b>" + newUser.getEmailId() + "</p></br>" + "<p><b>Password: </b>"
				+ newUser.getPassword() + "</p></br>" + "</body></html>";
		emailService.sendEmail(savedUser.getEmailId(), Constants.REGISTRATION_SUCCESSFUL_SUBJECT, message);
		// EmailUtil.sendMail(savedUser.getEmailId(), "Fox Logic - Registration
		// Successful", message);
		return savedUser;
	}

	public String checkForExistingEmail(String emailId) {
		User user = userRepository.findOne(emailId);
		return user == null ? "VALID_EMAIL" : "EMAIL_EXISTS";
	}

	public String checkForExistingUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		return user == null ? "VALID_USER_NAME" : "USER_NAME_EXISTS";
	}

	public boolean processForgotPassword(String emailId) {
		User user = userRepository.findOne(emailId);
		if (user == null) {
			return false;
		}
		String newPassword = PasswordUtil.generatePassword();
		user.setPassword(newPassword);
		userRepository.save(user);
		String message = "<html><body><h1>Dear " + user.getFirstName()
				+ "</h1></br></br><p>Your password is reset successfully. Please use the following credentials to Login:</p></br></br>"
				+ "<p><b>Email: </b>" + user.getEmailId() + "</p></br>" + "<p><b>Password: </b>" + newPassword
				+ "</p></br>" + "</body></html>";
		emailService.sendEmail(emailId, Constants.FORGOT_PASSWORD_SUBJECT, message);
		return true;
	}

	public void setSecurityKey(Device device) {
		if (device.getUser() != null) {
			String securityKey = SecurityUtil.generateSecureKey(device.getSerialNumber());
			device.setSecurityKey(securityKey);
			deviceRepository.save(device);
		}
	}
}
