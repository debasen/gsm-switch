package in.foxlogic.gsmswitch.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.foxlogic.gsmswitch.util.StringConstants;

@Configuration
public class BeanConfigurations {

	@Bean
	public Map<String, String> relayIdMap() {
		Map<String, String> relayIdMap = new HashMap<>();
		relayIdMap.put(StringConstants.RELAY_VIEW_ID1, StringConstants.RELAY_BEAN_ID1);
		relayIdMap.put(StringConstants.RELAY_VIEW_ID2, StringConstants.RELAY_BEAN_ID2);
		relayIdMap.put(StringConstants.RELAY_VIEW_ID3, StringConstants.RELAY_BEAN_ID3);
		relayIdMap.put(StringConstants.RELAY_VIEW_ID4, StringConstants.RELAY_BEAN_ID4);
		return relayIdMap;
	}

}
