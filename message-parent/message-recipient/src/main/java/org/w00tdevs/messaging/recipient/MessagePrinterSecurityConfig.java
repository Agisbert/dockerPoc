package org.w00tdevs.messaging.recipient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author agisbert
 *
 */
@Configuration
@EnableWebSecurity
public class MessagePrinterSecurityConfig extends WebSecurityConfigurerAdapter {


	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.httpBasic();
		http.authorizeRequests().antMatchers("/health").permitAll()
		.anyRequest().authenticated();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#userDetailsService()
	 */
	@Bean
	public UserDetailsService userDetailsService(){
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("{noop}password")
				.roles("USER").build());
		return manager;
	}


}