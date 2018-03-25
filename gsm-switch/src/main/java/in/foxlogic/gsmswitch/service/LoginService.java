package in.foxlogic.gsmswitch.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.foxlogic.gsmswitch.dao.UserRepository;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		in.foxlogic.gsmswitch.model.User user = userRepository.findOne(emailId);
		if (user == null) {
			throw new UsernameNotFoundException("No user exists with Email Id: " + emailId);
		}
		return new User(user.getEmailId(), user.getPassword(), user.isActive(), true, true, true,
				getUserAutorities(user));
	}

	private Set<GrantedAuthority> getUserAutorities(in.foxlogic.gsmswitch.model.User user) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return authorities;
	}
}
