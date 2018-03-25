package in.foxlogic.gsmswitch.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDto {
	@NotNull
	@Email(message = "Not a valid Email Id")
	private String emailId;
	@NotNull
	@Size(min = 3, max = 40, message = "Username should be between 3 to 20 characters")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Username can only contain letter and digit")
	private String userName;
	@NotNull(message = "First Name can not be blank")
	@Size(min = 3, max = 40, message = "First Name should be between 3 to 40 characters")
	@Pattern(regexp = "[a-zA-Z]+", message = "First Name can only contain letters")
	private String firstName;
	@NotNull(message = "Last Name can not be blank")
	@Size(min = 3, max = 40, message = "Last Name should be between 3 to 40 characters")
	@Pattern(regexp = "[a-zA-Z]+", message = "Last Name can only contain letters")
	private String lastName;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
