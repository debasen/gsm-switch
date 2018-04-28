package in.foxlogic.gsmswitch.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_DETAIL", uniqueConstraints = @UniqueConstraint(columnNames = { "USER_NAME", "EMAIL_ID" }))
public class User implements Serializable {

	private static final long serialVersionUID = -7169482524957358602L;
	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "ACTIVE")
	private boolean active;
	@Column(name = "ROLE")
	private String role;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Device> devices;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DEFAULT_DEVICE", referencedColumnName = "SERIAL_NUMBER")
	private Device defaultDevice;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device getDefaultDevice() {
		return defaultDevice;
	}

	public void setDefaultDevice(Device defaultDevice) {
		this.defaultDevice = defaultDevice;
	}

}
