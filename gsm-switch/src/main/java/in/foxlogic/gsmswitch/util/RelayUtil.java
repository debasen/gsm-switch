package in.foxlogic.gsmswitch.util;

import java.util.HashMap;
import java.util.Map;

import in.foxlogic.gsmswitch.dto.DeviceSessionDetails;

public class RelayUtil {

	public static Map<String, String> prepareRelayColorMap(DeviceSessionDetails deviceSessionDetails) {
		Map<String, String> relayColorMap = new HashMap<>();
		relayColorMap.put(StringConstants.RELAY_BEAN_ID1, getColorValue(deviceSessionDetails.isRelay1()));
		relayColorMap.put(StringConstants.RELAY_BEAN_ID2, getColorValue(deviceSessionDetails.isRelay2()));
		relayColorMap.put(StringConstants.RELAY_BEAN_ID3, getColorValue(deviceSessionDetails.isRelay3()));
		relayColorMap.put(StringConstants.RELAY_BEAN_ID4, getColorValue(deviceSessionDetails.isRelay4()));
		return relayColorMap;
	}

	/**
	 * return 'btn-success' if relay is on. Otherwise return 'btn-default'
	 * 
	 * @param status
	 * @return
	 */
	private static String getColorValue(boolean status) {
		return status ? StringConstants.BOOTSTRAP_BOTTON_COLOR_SECCESS : StringConstants.BOOTSTRAP_BOTTON_COLOR_DEFAULT;
	}
}
