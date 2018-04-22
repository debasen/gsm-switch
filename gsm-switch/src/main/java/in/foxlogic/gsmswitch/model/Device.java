package in.foxlogic.gsmswitch.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@Column(name = "RELAY")
	private boolean relay;
	@Column(name = "DEVICE_RELAY")
	private boolean deviceRelay;
	@Column(name = "DEVICE_FEEDBACK_RELAY")
	private boolean deviceFeedbackRelay;
	@Column(name = "SECURITY_KEY")
	private String securityKey;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_EMAIL_ID")
	private User user;
	@OneToMany(mappedBy = "device")
	private List<Sensor> sensorList;
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
	public boolean isRelay() {
		return relay;
	}
	public void setRelay(boolean relay) {
		this.relay = relay;
	}
	public boolean isDeviceRelay() {
		return deviceRelay;
	}
	public void setDeviceRelay(boolean deviceRelay) {
		this.deviceRelay = deviceRelay;
	}
	public boolean isDeviceFeedbackRelay() {
		return deviceFeedbackRelay;
	}
	public void setDeviceFeedbackRelay(boolean deviceFeedbackRelay) {
		this.deviceFeedbackRelay = deviceFeedbackRelay;
	}
	public String getSecurityKey() {
		return securityKey;
	}
	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Sensor> getSensorList() {
		return sensorList;
	}
	public void setSensorList(List<Sensor> sensorList) {
		this.sensorList = sensorList;
	}

}
