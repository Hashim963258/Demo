package com.jsp.ContactBook.SECURITY;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration        // this class is a Configuration class
@EnableWebSecurity   // informs server to enable the security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  // --> customize the HTTP security features, such as endpoints authorization // its an abstract class this needs some updation or there is better way to use or 
{
	@Override		// who can access
	public void configure(AuthenticationManagerBuilder auth) throws Exception  // AuthenticationManagerBuilder --> helps for building in memory authentication / and adding AuthenticationProvider 's.
	{
		auth.inMemoryAuthentication().withUser("hash").password("1234").roles("ADMIN");   // inMemoryAuthentication --> is the way for handling authentication in Spring Security
	}
	
	
	@Override     // what type of request, what auth
	public void configure(HttpSecurity http) throws Exception //
	{
		http.csrf().disable()        //1st default disable this help to disable the defauls security which is csrf  (cross site request forgery)
		.authorizeRequests()		// authorizing the users
		.antMatchers("/contact")	// for only this particular URL
		.authenticated()			// for authenticated user
		.anyRequest()				// --- till here authorization any request he can use
		.permitAll()				// allow all the user 
		.and()						//	add all the above and also the below one
		.httpBasic();				// basic auth0
	}
	
	
	@Bean						// annotates that spring // compares the password  
	public PasswordEncoder passwordEncoder()      // encodes the password and compares it with the one we have 
	{
		return NoOpPasswordEncoder.getInstance();  
	}
}

