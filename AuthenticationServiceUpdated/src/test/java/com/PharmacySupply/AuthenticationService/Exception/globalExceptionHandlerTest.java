package com.PharmacySupply.AuthenticationService.Exception;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.PharmacySupply.AuthenticationService.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
/*******************************************************************
 * globalExceptionHandlerTest class will test all Exception handler methods
 * *****************************************************************/
public class globalExceptionHandlerTest {
	@InjectMocks
	GlobalErrorHandler handler;
	@Mock
	ErrorResponse errorResponse;
	@Mock
	Environment env;
	/*
	 * This method is used to test the InvalidCredentialException method which occur
	 * when user credentials are wrong
	 */
	@Test
	public void TestInvalidCredentialException() {
		LoginFailedException loginFailedException = new LoginFailedException("message");
		log.info(env.getProperty("log.start"));
		assertNotNull(handler.InvalidCredentialException(loginFailedException));
	}
	/*
	 * This method is used to test the InvalidUsernameException method which occur
	 * when user not found in database
	 */
	@Test
	public void TestInvalidUsernameException() {
		UserNotFoundException usernotfound=new UserNotFoundException("message");
		log.info(env.getProperty("log.start"));
		assertNotNull(handler.InvalidUserException(usernotfound));
	}

}
