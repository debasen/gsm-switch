package in.foxlogic.gsmswitch.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtil {

	private static final String SECURITY_KEY_CONST = "foxlogic";

	public static String generateSecureKey(String emailId, String password) {
		String inputData = emailId + SECURITY_KEY_CONST + password;
		return DigestUtils.sha1Hex(inputData);
	}
}
