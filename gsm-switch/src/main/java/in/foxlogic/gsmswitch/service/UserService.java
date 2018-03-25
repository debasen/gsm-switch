package in.foxlogic.gsmswitch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.foxlogic.gsmswitch.dao.UserRepository;
import in.foxlogic.gsmswitch.model.User;
import in.foxlogic.gsmswitch.util.EmailUtil;
import in.foxlogic.gsmswitch.util.PasswordUtil;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User findUserById(String emailId) {
		return userRepository.findOne(emailId);
	}

	public User registerUser(User newUser) {
		String newPassword = PasswordUtil.generatePassword();
		newUser.setPassword(newPassword);
		newUser.setRole("ROLE_USER");
		newUser.setActive(true);
		User savedUser = userRepository.save(newUser);
		String message = "<html><body><h1>Welcome " + newUser.getFirstName()
				+ "</h1></br></br><p>Your account is created successfully. Please use the following credential to Login:</p></br></br>"
				+ "<p><b>Email: </b>" + newUser.getEmailId() + "</p></br>" + "<p><b>Password: </b>"
				+ newUser.getPassword() + "</p></br>" + "</body></html>";
		EmailUtil.sendMail(savedUser.getEmailId(), message);
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
}
