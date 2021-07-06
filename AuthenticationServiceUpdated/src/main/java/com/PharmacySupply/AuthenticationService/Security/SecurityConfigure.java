package com.PharmacySupply.AuthenticationService.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.PharmacySupply.AuthenticationService.Service.JwtRequestFilter;
import com.PharmacySupply.AuthenticationService.Service.MyUserDetailsService;

import lombok.extern.slf4j.Slf4j;
@EnableWebSecurity
@Slf4j
/**************************************************************
 * SecurityConfigure class is use to configure security on our MicroService
 * it contains method for implementing Authentication and Authorization
 * on our MicroService
 * configure(AuthenticationManagerBuilder auth) => for authentication
 * configure(HttpSecurity http) => for authorization
 * configure(WebSecurity web) => for configuration settings
 ************************************************************/
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtRequestFilter jwtfilter;
	@Autowired
	private Environment env;
	/*
	 *This method use for user authentication basically it check weather the 
	 *incoming user is present or not if it present the it will authenticate that user
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getpasswordEncoder());
	}
	/*
	 * This method use for authorization it tells which endpoints are accessible by
	 * all the user and which endpoints are only accessible by authenticated user
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info(env.getProperty("log.start"));
		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtfilter,UsernamePasswordAuthenticationFilter.class);
		log.info(env.getProperty("log.end"));
	}
	/*
	 * This method is used for configuration setting that impact global security
	 * spring security will ignore all the endpoints which are present inside it
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		log.info(env.getProperty("log.start"));
		web.ignoring().antMatchers("/h2/**","/actuator/health/**","/v2/api-docs","/configuration/ui","/swagger-resources/**","/configuration/security","/swagger-ui.html","/webjars/**","/auth/swagger");
		log.info(env.getProperty("log.end"));
	}
	/*
	 * This bean is used to encode plaintext password into Bcrypt form
	 * it is use for saving the password
	 */
	@Bean
	public PasswordEncoder getpasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	/*
	 * This bean return the authenticationManager of WebSecurityConfigurerAdapter
	 */
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception
	{
		return super.authenticationManagerBean();
	}

}
