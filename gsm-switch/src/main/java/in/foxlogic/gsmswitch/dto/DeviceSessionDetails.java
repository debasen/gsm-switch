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
	private boolean relay1;
	private boolean relay2;
	private boolean relay3;
	private boolean relay4;
	private String userEmailId;

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

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

}
