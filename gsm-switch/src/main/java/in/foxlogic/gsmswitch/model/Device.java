package in.foxlogic.gsmswitch.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICE_DETAIL")
public class Device {

	@Id
	@Column(name = "DEVICE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deviceId;
	@Column(name = "SERIAL_NUMBER")
	private Long serialNumber;
	@Column(name = "DEVICE_NAME")
	private String deviceName;
	@Column(name = "MODEL_NUMBER")
	private String modelNumber;
	@Column(name = "RELAY1")
	private boolean relay1;
	@Column(name = "RELAY2")
	private boolean relay2;
	@Column(name = "RELAY3")
	private boolean relay3;
	@Column(name = "RELAY4")
	private boolean relay4;
	@Column(name = "DEVICE_RELAY1")
	private boolean deviceRelay1;
	@Column(name = "DEVICE_RELAY2")
	private boolean deviceRelay2;
	@Column(name = "DEVICE_RELAY3")
	private boolean deviceRelay3;
	@Column(name = "DEVICE_RELAY4")
	private boolean deviceRelay4;
	@Column(name = "SECURITY_KEY")
	private String securityKey;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_EMAIL_ID")
	User user;

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public boolean isRelay1() {
		return relay1;
	}

	public void setRelay1(boolean relay1) {
		this.relay1 = relay1;
	}

	public boolean isRelay2() {
		return relay2;
	}

	public void setRelay2(boolean relay2) {
		this.relay2 = relay2;
	}

	public boolean isRelay3() {
		return relay3;
	}

	public void setRelay3(boolean relay3) {
		this.relay3 = relay3;
	}

	public boolean isRelay4() {
		return relay4;
	}

	public void setRelay4(boolean relay4) {
		this.relay4 = relay4;
	}

	public boolean isDeviceRelay1() {
		return deviceRelay1;
	}

	public void setDeviceRelay1(boolean deviceRelay1) {
		this.deviceRelay1 = deviceRelay1;
	}

	public boolean isDeviceRelay2() {
		return deviceRelay2;
	}

	public void setDeviceRelay2(boolean deviceRelay2) {
		this.deviceRelay2 = deviceRelay2;
	}

	public boolean isDeviceRelay3() {
		return deviceRelay3;
	}

	public void setDeviceRelay3(boolean deviceRelay3) {
		this.deviceRelay3 = deviceRelay3;
	}

	public boolean isDeviceRelay4() {
		return deviceRelay4;
	}

	public void setDeviceRelay4(boolean deviceRelay4) {
		this.deviceRelay4 = deviceRelay4;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

}
