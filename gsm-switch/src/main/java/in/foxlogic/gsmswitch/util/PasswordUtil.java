package in.foxlogic.gsmswitch.util;

import java.security.SecureRandom;
import java.math.BigInteger;

public class PasswordUtil {

	public static String generatePassword(){
		SecureRandom random = new SecureRandom();
		return new BigInteger(28, random).toString(32);
	}
}
