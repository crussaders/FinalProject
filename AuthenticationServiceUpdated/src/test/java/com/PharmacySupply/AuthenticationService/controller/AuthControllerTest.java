package com.PharmacySupply.AuthenticationService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.PharmacySupply.AuthenticationService.Service.JwtUtil;
import com.PharmacySupply.AuthenticationService.Service.MyUserDetailsService;
import com.PharmacySupply.AuthenticationService.model.UserLoginCredentials;
import com.PharmacySupply.AuthenticationService.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
/*******************************************************************
 * AuthControllerTest class is use to test the AuthController class 
 * method and check weather the method are working properly or not
 * *****************************************************************/
public class AuthControllerTest {
	
	@InjectMocks
	AuthController authController;
	UserDetails userdetail;
	@Mock
	JwtUtil jwtUtil;
	@Mock
	MyUserDetailsService service;
	@Mock
	AuthenticationManager authmanager;
	@Mock
	UserRepository repo;
	@Mock
	Environment env;
	/*
	 * This method test the health method of AuthController
	 */
//	@Test
//	public void Testhealth() {
//		ResponseEntity<?> health=authController.healthCheckup();
//		assertEquals(200 , health.getStatusCodeValue());
//	}
	
	/**
	 * This method is used to check the credentials whether the provided credentials
	 * are correct or not. For this we will call authenticate method. If user
	 * credentials are correct then we will fetch the data from database based on
	 * userId and return it to the user with a token
	 * */
	@Test
	public void TestLogin() throws Exception
	{
		UserLoginCredentials user = new UserLoginCredentials("admin", "admin");
		
		UserDetails loadUserByUsername = service.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserid(), user.getPassword(), new ArrayList<>());
		when(service.loadUserByUsername("admin")).thenReturn(value);
		when(jwtUtil.generateToken(loadUserByUsername)).thenReturn("token");
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.request"),user);
		ResponseEntity<?> login = authController.Login(user);
		log.info(env.getProperty("log.end"));
		assertEquals( 200 , login.getStatusCodeValue() );
	}
	/**
	 * This method is used to test the validity of token
	 * */
	@Test
	public void Testvalidity() {

		log.info(env.getProperty("log.start"));
		when(jwtUtil.validateToken("token")).thenReturn(true);
		when(jwtUtil.extractUsername("token")).thenReturn("admin");
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(validity.getBody().toString().contains("true"), true);
		log.info(env.getProperty("log.end"));

	}
	

}
