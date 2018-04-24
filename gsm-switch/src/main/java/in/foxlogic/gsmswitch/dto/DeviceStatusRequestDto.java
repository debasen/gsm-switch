package in.foxlogic.gsmswitch.dto;

import javax.validation.constraints.NotNull;

public class DeviceStatusRequestDto {

	@NotNull
	private Long sNo;
	@NotNull
	private String secKy;
	@NotNull
	private boolean rly;
	@NotNull
	private boolean frly;

	public Long getsNo() {
		return sNo;
	}

	public void setsNo(Long sNo) {
		this.sNo = sNo;
	}

	public String getSecKy() {
		return secKy;
	}

	public void setSecKy(String secKy) {
		this.secKy = secKy;
	}

	public boolean isRly() {
		return rly;
	}

	public void setRly(boolean rly) {
		this.rly = rly;
	}

	public boolean isFrly() {
		return frly;
	}

	public void setFrly(boolean frly) {
		this.frly = frly;
	}

}
