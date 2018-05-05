package in.foxlogic.gsmswitch.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import in.foxlogic.gsmswitch.util.Constants;

@Configuration
public class BeanConfigurations {

	@Bean
	@Scope(scopeName = "singleton")
	public List<Integer> sensorAddressList() {
		List<Integer> sensorAddressList = new ArrayList<>();
		sensorAddressList.add(Constants.OPERATING_FREQUENCY_ADDRESS);
		sensorAddressList.add(Constants.OPERATING_CURRENT_ADDRESS);
		sensorAddressList.add(Constants.DC_VOLTAGE_ADDRESS);
		sensorAddressList.add(Constants.AC_VOLTAGE_ADDRESS);
		sensorAddressList.add(Constants.IGBT_TEMPERATURE_ADDRESS);
		return sensorAddressList;
	}
	
	@Bean
	@Scope(scopeName = "singleton")
	public List<Integer> sensorCrcList() {
		List<Integer> sensorAddressList = new ArrayList<>();
		sensorAddressList.add(Constants.OPERATING_FREQUENCY_CRC);
		sensorAddressList.add(Constants.OPERATING_CURRENT_CRC);
		sensorAddressList.add(Constants.DC_VOLTAGE_CRC);
		sensorAddressList.add(Constants.AC_VOLTAGE_CRC);
		sensorAddressList.add(Constants.IGBT_TEMPERATURE_CRC);
		return sensorAddressList;
	}

	@Bean
	@Scope(scopeName = "singleton")
	public Map<Integer, String> sensorMap() {
		Map<Integer, String> sensorMap = new HashMap<>();
		sensorMap.put(Constants.OPERATING_FREQUENCY_ADDRESS, Constants.OPERATING_FREQUENCY);
		sensorMap.put(Constants.OPERATING_CURRENT_ADDRESS, Constants.OPERATING_CURRENT);
		sensorMap.put(Constants.DC_VOLTAGE_ADDRESS, Constants.DC_VOLTAGE);
		sensorMap.put(Constants.AC_VOLTAGE_ADDRESS, Constants.AC_VOLTAGE);
		sensorMap.put(Constants.IGBT_TEMPERATURE_ADDRESS, Constants.IGBT_TEMPERATURE);
		return sensorMap;
	}
}
