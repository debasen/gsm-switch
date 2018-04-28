package in.foxlogic.gsmswitch.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class DeviceSessionDetails {
	private Long deviceId;
	private Long serialNumber;
	private String deviceName;
	private String modelNumber;
	private boolean relay;
	private boolean deviceRelay;
	private boolean deviceFeedbackRelay;
	private String userEmailId;
	private String relayColor;
	private String lastConnectedDate;
	private String lastConnectedTime;
	private boolean isNotReachable;

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

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
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

	public String getRelayColor() {
		return relayColor;
	}

	public void setRelayColor(String relayColor) {
		this.relayColor = relayColor;
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

	public boolean isNotReachable() {
		return isNotReachable;
	}

	public void setNotReachable(boolean isNotReachable) {
		this.isNotReachable = isNotReachable;
	}

}
