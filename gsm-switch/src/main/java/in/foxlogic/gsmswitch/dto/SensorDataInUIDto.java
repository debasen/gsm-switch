package in.foxlogic.gsmswitch.dto;

public class SensorDataInUIDto {
	private String operatingFrequency;
	private String operatingCurrent;
	private String acVoltage;
	private String dcVoltage;
	private String date;
	private String time;
	private String igbtTemperature;

	public String getOperatingFrequency() {
		return operatingFrequency;
	}

	public void setOperatingFrequency(String operatingFrequency) {
		this.operatingFrequency = operatingFrequency;
	}

	public String getOperatingCurrent() {
		return operatingCurrent;
	}

	public void setOperatingCurrent(String operatingCurrent) {
		this.operatingCurrent = operatingCurrent;
	}

	public String getAcVoltage() {
		return acVoltage;
	}

	public void setAcVoltage(String acVoltage) {
		this.acVoltage = acVoltage;
	}

	public String getDcVoltage() {
		return dcVoltage;
	}

	public void setDcVoltage(String dcVoltage) {
		this.dcVoltage = dcVoltage;
	}

	public String getIgbtTemperature() {
		return igbtTemperature;
	}

	public void setIgbtTemperature(String igbtTemperature) {
		this.igbtTemperature = igbtTemperature;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
