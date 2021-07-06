package com.PharmacySupply.AuthenticationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.PharmacySupply.AuthenticationService.Exception.LoginFailedException;
import com.PharmacySupply.AuthenticationService.Service.JwtUtil;
import com.PharmacySupply.AuthenticationService.Service.MyUserDetailsService;
import com.PharmacySupply.AuthenticationService.model.JwtValidateResponse;
import com.PharmacySupply.AuthenticationService.model.MyUserDetails;
import com.PharmacySupply.AuthenticationService.model.UserLoginCredentials;
import com.PharmacySupply.AuthenticationService.model.UserToken;
import com.PharmacySupply.AuthenticationService.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


/*****************************************************************
 * AuthController is a rest controller which is responsible for
 * generating JWT token after authentication and also validate the  
 * JWT TOKEN
 * "/health" => for  health check of microservice
 * "/login" => for authenticate user and generate token
 * "/validate" => for validate JWT token
 * ****************************************************************/
@RestController
@Slf4j
public class AuthController {

	@Autowired
	private AuthenticationManager authmanager;
	@Autowired
	private MyUserDetailsService userdetails;
	@Autowired
	private JwtUtil jwtUtils;
	@Autowired
	private UserRepository repo;
	@Autowired
	private Environment env;
	
	/* 
	 * This method used for checking the health of MicroService 
	 * */
	
//	@GetMapping("/health")
//	public ResponseEntity<?> healthCheckup() {
//		log.info("AWS Health Check");
//		return new ResponseEntity<>("Authenticated successfully", HttpStatus.OK);
//	}
	
	/*
	 *  This method takes the UserLoginCredentails POJO class as a Request 
	 * Authenticate the Request and if the UserLoginCredentials are authenticated
	 * then generated JWT Token and return UserToken POJO class as Response and If Request is not 
	 * Authenticate then it give LoginFailedException
	 */
	@PostMapping("/login")
	public ResponseEntity<UserToken> Login(@RequestBody UserLoginCredentials authrequest) throws Exception
	{
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.request"),authrequest);
		try
		{
			authmanager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserid(),authrequest.getPassword()));
		}
		catch(BadCredentialsException badCredentialException) {
			log.error(env.getProperty("log.login"));
			throw new LoginFailedException(env.getProperty("ex.loginfail"));
		}
		final UserDetails userDetails = userdetails.loadUserByUsername(authrequest.getUserid());
		final String jwt=jwtUtils.generateToken(userDetails);
		log.debug(env.getProperty("log.token"),jwt);
		UserToken token = new UserToken(authrequest.getUserid(),jwt);
		log.debug(env.getProperty("log.response"),token);
		log.info(env.getProperty("log.end"));
		return ResponseEntity.ok(token);
	}
	
	/*
	 * This method takes the Authorization Request header as parameter
	 * which contains JWT token with Bearer it will extract the token from Request Header
	 * and check for token validity with token validate the return JwtValidateResponse POJO
	 * class as response  
	 * */
	@GetMapping(value = "/validate")
	public ResponseEntity<JwtValidateResponse> getValidity(@RequestHeader(name="Authorization",required = true) String token1){
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.bearertoken"), token1);
		String token = token1.substring(7);
		log.debug(env.getProperty("log.token"),token);
		JwtValidateResponse validate=new JwtValidateResponse();
			if (jwtUtils.validateToken(token))
			{
				log.debug(env.getProperty("log.tokenvalid"));
				validate.setUserid(jwtUtils.extractUsername(token));
				validate.setValid(true);
				//validate.setUsername(repo.findById(jwtUtils.extractUsername(token)).get().getName());
			}
			else
			{
				log.error(env.getProperty("log.tokeninvalid"));
				validate.setValid(false);
			}
			log.debug(env.getProperty("log.response"), validate);
			log.info(env.getProperty("log.end"));
		return new ResponseEntity<JwtValidateResponse>(validate, HttpStatus.OK);
	}
}
