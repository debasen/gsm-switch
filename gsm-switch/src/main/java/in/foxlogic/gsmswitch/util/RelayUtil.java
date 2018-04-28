package in.foxlogic.gsmswitch.util;

import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;

public class RelayUtil {

	/**
	 * Get button color value based on device relay state
	 * 
	 * @param status
	 * @return
	 */
	public static String getColorValue(DeviceSessionDetails deviceSessionDetails) {
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

	public static String convertSensorRawData(String sensorType, int value) {
		String transformedValue = "";
		switch (sensorType) {
		case Constants.OPERATING_FREQUENCY:
			transformedValue = String.valueOf(value);
			break;
		case Constants.OPERATING_CURRENT:
			transformedValue = String.valueOf(value);
			break;
		case Constants.DC_VOLTAGE:
			transformedValue = String.valueOf(value);
			break;
		case Constants.AC_VOLTAGE:
			transformedValue = String.valueOf(value);
			break;
		case Constants.IGBT_TEMPERATURE:
			transformedValue = String.valueOf(value);
			break;
		}
		return transformedValue;
	}
}
