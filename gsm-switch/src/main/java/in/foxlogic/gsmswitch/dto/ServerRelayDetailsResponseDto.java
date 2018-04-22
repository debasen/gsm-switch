package in.foxlogic.gsmswitch.dto;

public class ServerRelayDetailsResponseDto {

	private boolean relayState;
	private int registerAddress;

	public boolean isRelayState() {
		return relayState;
	}

	public void setRelayState(boolean relayState) {
		this.relayState = relayState;
	}

	public int getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(int registerAddress) {
		this.registerAddress = registerAddress;
	}

}
