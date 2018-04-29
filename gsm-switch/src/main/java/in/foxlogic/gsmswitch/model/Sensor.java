package in.foxlogic.gsmswitch.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Sensor {
	@Column(name = "OPERATING_FREQUENCY")
	private String operatingFrequency;
	@Column(name = "OPERATING_CURRENT")
	private String operatingCurrent;
	@Column(name = "DC_VOLTAGE")
	private String dcVoltage;
	@Column(name = "AC_VOLTAGE")
	private String acVoltage;
	@Column(name = "IGBT_TEMPERATURE")
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

	public String getDcVoltage() {
		return dcVoltage;
	}

	public void setDcVoltage(String dcVoltage) {
		this.dcVoltage = dcVoltage;
	}

	public String getAcVoltage() {
		return acVoltage;
	}

	public void setAcVoltage(String acVoltage) {
		this.acVoltage = acVoltage;
	}

	public String getIgbtTemperature() {
		return igbtTemperature;
	}

	public void setIgbtTemperature(String igbtTemperature) {
		this.igbtTemperature = igbtTemperature;
	}

}