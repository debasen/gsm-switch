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
			return StringConstants.BOOTSTRAP_COLOR_DANGER;
		} else {
			if ((deviceSessionDetails.isRelay() == deviceSessionDetails.isDeviceRelay())
					&& deviceSessionDetails.isRelay() == true) {
				return StringConstants.BOOTSTRAP_COLOR_SUCCESS;
			} else if ((deviceSessionDetails.isRelay() == deviceSessionDetails.isDeviceRelay())
					&& deviceSessionDetails.isRelay() == false) {
				return StringConstants.BOOTSTRAP_COLOR_DEFAULT;
			} else {
				return StringConstants.BOOTSTRAP_COLOR_INFO;
			}
		}
	}
}
