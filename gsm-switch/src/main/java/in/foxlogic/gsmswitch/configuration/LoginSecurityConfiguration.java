package in.foxlogic.gsmswitch.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * LoginSecurityConfiguration configures Spring Security
 * 
 * @author Debapriya
 *
 */
@Configuration
@EnableWebSecurity
public class LoginSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService loginService;

	/**
	 * Get user details from UserRepository
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/welcome", "/sign-up", "/server-relay-state")
				.permitAll();
		http.authorizeRequests().antMatchers("/dashboard").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").and().csrf().disable();
		// Enable h2 console login
		http.headers().frameOptions().disable();
		http.formLogin().loginPage("/welcome").loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("emailId").passwordParameter("password").defaultSuccessUrl("/dashboard")
				.failureUrl("/login?error").and().logout().logoutUrl("/logout").logoutSuccessUrl("/welcome");

	}
}