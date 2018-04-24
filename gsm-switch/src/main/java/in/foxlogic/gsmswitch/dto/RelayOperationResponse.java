package in.foxlogic.gsmswitch.dto;

public class RelayOperationResponse {

	private String buttonColor;
	private boolean relayStatus;

	public String getButtonColor() {
		return buttonColor;
	}

	public void setButtonColor(String buttonColor) {
		this.buttonColor = buttonColor;
	}

	public boolean isRelayStatus() {
		return relayStatus;
	}

	public void setRelayStatus(boolean relayStatus) {
		this.relayStatus = relayStatus;
	}

}
