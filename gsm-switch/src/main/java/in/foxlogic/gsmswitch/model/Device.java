package in.foxlogic.gsmswitch.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICE_DETAIL")
public class Device implements Serializable {

	private static final long serialVersionUID = -4887992758189969984L;
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
	@Column(name = "LAST_CONNECTED_DATE")
	private String lastConnectedDate;
	@Column(name = "LAST_CONNECTED_TIME")
	private String lastConnectedTime;
	@Column(name = "SECURITY_KEY")
	private String securityKey;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_EMAIL_ID")
	private User user;
	@Embedded
	private Sensor sensors;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "DEVICE_ID")
	private List<StatusHistory> statusHistory;

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

	public String getLastConnectedDate() {
		return lastConnectedDate;
	}

	public void setLastConnectedDate(String lastConnectedDate) {
		this.lastConnectedDate = lastConnectedDate;
	}

	public String getLastConnectedTime() {
		return lastConnectedTime;
	}

	public void setLastConnectedTime(String lastConnectedTime) {
		this.lastConnectedTime = lastConnectedTime;
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

	public Sensor getSensors() {
		return sensors;
	}

	public void setSensors(Sensor sensors) {
		this.sensors = sensors;
	}

	public List<StatusHistory> getStatusHistory() {
		return statusHistory;
	}

	public void setStatusHistory(List<StatusHistory> statusHistory) {
		this.statusHistory = statusHistory;
	}

}
