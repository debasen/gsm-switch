package in.foxlogic.gsmswitch.dto;

import java.util.List;

import in.foxlogic.gsmswitch.model.StatusHistory;

public class PollServerResponse {

	private boolean relay;
	private boolean deviceRelay;
	private String relayColor;
	private String networkStatus;
	private String lastConnectedDate;
	private String lastConnectedTime;
	private String deviceRelayString;
	private String lastStatusUpdated;
	private SensorDataInUIDto sensorData;
	private String emptyHistoryMessage;
	private boolean emptyHistory;
	private List<SensorDataInUIDto> statusHistories;

	public boolean isRelay() {
		return relay;
	}

	public void setRelay(boolean relay) {
		this.relay = relay;
	}

	public String getRelayColor() {
		return relayColor;
	}

	public void setRelayColor(String relayColor) {
		this.relayColor = relayColor;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public String getLastConnectedTime() {
		return lastConnectedTime;
	}

	public void setLastConnectedTime(String lastConnectedTime) {
		this.lastConnectedTime = lastConnectedTime;
	}

	public String getDeviceRelayString() {
		return deviceRelayString;
	}

	public void setDeviceRelayString(String deviceRelayString) {
		this.deviceRelayString = deviceRelayString;
	}

	public String getLastStatusUpdated() {
		return lastStatusUpdated;
	}

	public void setLastStatusUpdated(String lastStatusUpdated) {
		this.lastStatusUpdated = lastStatusUpdated;
	}

	public SensorDataInUIDto getSensorData() {
		return sensorData;
	}

	public void setSensorData(SensorDataInUIDto sensorData) {
		this.sensorData = sensorData;
	}

	public String getEmptyHistoryMessage() {
		return emptyHistoryMessage;
	}

	public void setEmptyHistoryMessage(String emptyHistoryMessage) {
		this.emptyHistoryMessage = emptyHistoryMessage;
	}

	public boolean isEmptyHistory() {
		return emptyHistory;
	}

	public void setEmptyHistory(boolean emptyHistory) {
		this.emptyHistory = emptyHistory;
	}

	public boolean isDeviceRelay() {
		return deviceRelay;
	}

	public void setDeviceRelay(boolean deviceRelay) {
		this.deviceRelay = deviceRelay;
	}

	public String getLastConnectedDate() {
		return lastConnectedDate;
	}

	public void setLastConnectedDate(String lastConnectedDate) {
		this.lastConnectedDate = lastConnectedDate;
	}

	public List<SensorDataInUIDto> getStatusHistories() {
		return statusHistories;
	}

	public void setStatusHistories(List<SensorDataInUIDto> statusHistories) {
		this.statusHistories = statusHistories;
	}

}
