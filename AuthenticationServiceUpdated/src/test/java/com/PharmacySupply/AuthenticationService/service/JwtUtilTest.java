package com.PharmacySupply.AuthenticationService.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.PharmacySupply.AuthenticationService.Service.JwtUtil;
import com.PharmacySupply.AuthenticationService.Service.MyUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
/********************************************************
 * JwtUtilTest class is used to test the JwtUtil methods 
 * weather they are working properly or not
 ********************************************************/
@RunWith(SpringRunner.class)
public class JwtUtilTest {
	private UserDetails udetails;
    @InjectMocks
    JwtUtil jwtutil;
    @Mock
    MyUserDetailsService service;
    @Mock
    Environment env;
    
    /*
     *This method is used to test the generateToken method which is responsible
     *for generating token when user is authenticated
     */
    @Test
	public void TestgenerateToken() {
		log.info(env.getProperty("log.start"));
		udetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtutil.generateToken(udetails);
		assertNotNull(generateToken);
		log.info(env.getProperty("log.end"));
	}
    /**
	 * This method is used to test the token based on the given token and
	 * userDetails as parameter. First from the token we will extract the user name
	 * and then will check in the database whether the token extracted user name and
	 * the user residing in database is same or not and also will check whether the
	 * token has been expired or not
	 */
	@Test
	public void TestvalidateToken() {
		log.info(env.getProperty("log.start"));
		udetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtutil.generateToken(udetails);
		Boolean validateToken = jwtutil.validateToken(generateToken);
		assertEquals(true, validateToken);
		log.info(env.getProperty("log.end"));
	}
	/*
	 * to test the validity of token with userid
	 */
	@Test
	public void TestvalidateTokenWithuserId() {
		log.info(env.getProperty("log.start"));
		udetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtutil.generateToken(udetails);
		Boolean validateToken = jwtutil.validateToken(generateToken, udetails);
		assertEquals(true, validateToken);
		log.info(env.getProperty("log.end"));

	}
	/**
	 * to test the validity of token with false userid
	 */
	@Test
	public void TestvalidateTokenWithUserIdFalse() {
		log.info(env.getProperty("log.start"));
		udetails = new User("admin", "admin", new ArrayList<>());
		UserDetails user1 = new User("admin1", "admin1", new ArrayList<>());
		String generateToken = jwtutil.generateToken(udetails);
		Boolean validateToken = jwtutil.validateToken(generateToken, user1);
		assertEquals(false, validateToken);
		log.info(env.getProperty("log.end"));
	}
}