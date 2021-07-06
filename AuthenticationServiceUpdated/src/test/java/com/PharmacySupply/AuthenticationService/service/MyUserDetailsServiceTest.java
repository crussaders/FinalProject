package com.PharmacySupply.AuthenticationService.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.PharmacySupply.AuthenticationService.Service.MyUserDetailsService;
import com.PharmacySupply.AuthenticationService.model.MyUserDetails;
import com.PharmacySupply.AuthenticationService.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
/********************************************************
 * MyUserDetailsServiceTest is used to check the details of the
 * user for authentication if user present then that user is 
 * authenticated 
 ********************************************************/
public class MyUserDetailsServiceTest {
	private UserDetails userdetails;
	@InjectMocks
	MyUserDetailsService service;
	@Mock
	UserRepository repo;
	@Mock
	Environment env;
	/*
	 * This method is used to test  user details from database and checking
	 * whether the user resides in database or not based on the given id. If the
	 * user not present in the database it will throw an exception
	 * UserNotFoundException. And if user is present in the database it will
	 */
	@Test
	public void TestloadUserByUsernameTest() {
		log.info(env.getProperty("log.start"));
		MyUserDetails user1=new MyUserDetails("admin","admin","admin","admin","admin");
		Optional<MyUserDetails> data =Optional.of(user1);
		when(repo.findById("admin")).thenReturn(data);
		userdetails = service.loadUserByUsername("admin");
		log.debug(env.getProperty("log.userDetails"),userdetails);
		log.info(env.getProperty("log.end"));
		assertEquals(user1.getUserid(),userdetails.getUsername());
	}

}
