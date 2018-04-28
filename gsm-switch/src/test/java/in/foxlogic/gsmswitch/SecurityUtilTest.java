package in.foxlogic.gsmswitch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.foxlogic.gsmswitch.util.SecurityUtil;

public class SecurityUtilTest {

	@Test
	public void testSecureKeyGeneration() {

		assertEquals("3a3d5", SecurityUtil.generateSecureKey(312315L));
	}
}
