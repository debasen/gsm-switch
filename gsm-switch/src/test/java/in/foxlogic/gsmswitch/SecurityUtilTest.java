package in.foxlogic.gsmswitch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.foxlogic.gsmswitch.util.SecurityUtil;

public class SecurityUtilTest {

	@Test
	public void testSecureKeyGeneration() {
		assertEquals("bbca65bc5bef245a0c15be37ad281eeb553b8f00",
				SecurityUtil.generateSecureKey("deb.sen93@gmail.com", "password"));
	}
}
