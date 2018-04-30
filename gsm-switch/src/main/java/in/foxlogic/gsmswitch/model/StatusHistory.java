package in.foxlogic.gsmswitch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS_HISTORY")
public class StatusHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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
	@Column(name = "DATE")
	private String date;
	@Column(name = "TIME")
	private String time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
