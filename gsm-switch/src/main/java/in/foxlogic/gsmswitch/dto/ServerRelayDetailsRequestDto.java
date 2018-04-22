package in.foxlogic.gsmswitch.dto;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class ServerRelayDetailsRequestDto {
	@NotNull
	private Long serialNumber;
	@NotNull
	private String securityKey;
	@NotNull
	private int iterationIndex;

	public Long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getIterationIndex() {
		return iterationIndex;
	}

	public void setIterationIndex(int iterationIndex) {
		this.iterationIndex = iterationIndex;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

}
