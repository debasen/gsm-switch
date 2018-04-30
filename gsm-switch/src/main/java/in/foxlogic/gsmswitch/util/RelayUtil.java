package in.foxlogic.gsmswitch.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;
import in.foxlogic.gsmswitch.dto.PollServerResponse;
import in.foxlogic.gsmswitch.dto.SensorDataInUIDto;
import in.foxlogic.gsmswitch.model.StatusHistory;

public class RelayUtil {

	/**
	 * Get button color value based on device relay state
	 * 
	 * @param status
	 * @return
	 */
	public static String getColorValue(DeviceSessionDetails deviceSessionDetails) {
		if (deviceSessionDetails.isNotReachable()) {
			return Constants.BOOTSTRAP_COLOR_INFO;
		}
		if (deviceSessionDetails.isDeviceRelay() != deviceSessionDetails.isDeviceFeedbackRelay()) {
			return Constants.BOOTSTRAP_COLOR_DANGER;
		} else {
			if ((deviceSessionDetails.isRelay() == deviceSessionDetails.isDeviceRelay())
					&& deviceSessionDetails.isRelay() == true) {
				return Constants.BOOTSTRAP_COLOR_SUCCESS;
			} else if ((deviceSessionDetails.isRelay() == deviceSessionDetails.isDeviceRelay())
					&& deviceSessionDetails.isRelay() == false) {
				return Constants.BOOTSTRAP_COLOR_DEFAULT;
			} else {
				return Constants.BOOTSTRAP_COLOR_INFO;
			}
		}
	}

	public static String sensorRawToDatabase(String sensorType, int value) {
		String transformedValue = "";
		switch (sensorType) {
		case Constants.OPERATING_FREQUENCY:
			transformedValue = String.valueOf(value / 100);
			break;
		case Constants.OPERATING_CURRENT:
			transformedValue = String.valueOf(value / 100);
			break;
		case Constants.DC_VOLTAGE:
			transformedValue = String.valueOf(value / 10);
			break;
		case Constants.AC_VOLTAGE:
			transformedValue = String.valueOf(value / 100 * 2);
			break;
		case Constants.IGBT_TEMPERATURE:
			transformedValue = String.valueOf(value / 100 + 2);
			break;
		}
		return transformedValue;
	}

	public static void databaseRawToUI(SensorDataInUIDto sensorDataInUIDto, StatusHistory statusHistoryObject) {
		sensorDataInUIDto.setOperatingFrequency(statusHistoryObject.getOperatingFrequency() + " Hz");
		sensorDataInUIDto.setOperatingCurrent(statusHistoryObject.getOperatingCurrent() + " A");
		sensorDataInUIDto.setAcVoltage(statusHistoryObject.getAcVoltage() + " V");
		sensorDataInUIDto.setDcVoltage(statusHistoryObject.getDcVoltage() + " V");
		sensorDataInUIDto.setIgbtTemperature(statusHistoryObject.getIgbtTemperature() + " °C");
		sensorDataInUIDto.setDate(LocalDate.parse(statusHistoryObject.getDate())
				.format(DateTimeFormatter.ofPattern(Constants.UI_DATE_FORMAT)));
		sensorDataInUIDto.setTime(LocalTime.parse(statusHistoryObject.getTime())
				.format(DateTimeFormatter.ofPattern(Constants.UI_STATUS_HISTORY_FORMAT)));
	}

	public static void convertHistoryFromDbToUi(DeviceSessionDetails deviceSessionDetails,
			PollServerResponse pollServerResponse) {
		if (!deviceSessionDetails.getStatusHistory().isEmpty()) {
			List<SensorDataInUIDto> sensorDataInUIDtos = new ArrayList<>();
			for (StatusHistory history : deviceSessionDetails.getStatusHistory()) {
				SensorDataInUIDto sensorDataInUIDto = new SensorDataInUIDto();
				databaseRawToUI(sensorDataInUIDto, history);
				sensorDataInUIDtos.add(sensorDataInUIDto);
			}
			pollServerResponse.setStatusHistories(sensorDataInUIDtos);
		}
	}
}
