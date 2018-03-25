package in.foxlogic.gsmswitch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.foxlogic.gsmswitch.dao.UserRepository;
import in.foxlogic.gsmswitch.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GsmSwitchApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	public void testGetUserWithEmail() {
		User user = userRepository.getOne("deb.sen93@gmail.com");
		assertEquals("Debapriya", user.getFirstName());
	}

}
