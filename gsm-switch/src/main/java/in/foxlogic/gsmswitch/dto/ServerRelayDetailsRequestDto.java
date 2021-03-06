package in.foxlogic.gsmswitch.dto;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class ServerRelayDetailsRequestDto {
	@NotNull
	private Long sNo;
	@NotNull
	private String secKy;
	@NotNull
	private int lIndx;

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

	public int getlIndx() {
		return lIndx;
	}

	public void setlIndx(int lIndx) {
		this.lIndx = lIndx;
	}

}
