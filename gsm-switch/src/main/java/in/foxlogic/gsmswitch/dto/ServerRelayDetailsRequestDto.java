package in.foxlogic.gsmswitch.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class ServerRelayDetailsRequestDto {
	@NotNull
	@Pattern(regexp = "[0-9]+", message = "Serial Number Must be numeric")
	private String serialNumber;
	@NotNull
	private String securityKey;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

}
