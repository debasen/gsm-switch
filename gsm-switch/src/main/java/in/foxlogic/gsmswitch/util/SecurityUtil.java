package in.foxlogic.gsmswitch.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtil {

	private static final String SECURITY_KEY_CONST = "foo";

	public static String generateSecureKey(Long deviceSerialNumber) {
		String inputData = SECURITY_KEY_CONST + deviceSerialNumber;
		return DigestUtils.sha1Hex(inputData).substring(0, 5);
	}
}
