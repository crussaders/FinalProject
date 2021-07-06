package com.cognizant.medRepSchedule.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InvalidTokenExceptionTest {

	@Mock
	private InvalidTokenException tokenNotValid;
	/*
     * checking for invalid token message. 
     * */
	@Test
	public void testtestInvalidTokenMessage() {
		InvalidTokenException tokenNotValid = new InvalidTokenException("Token validaton failed.");
		assertEquals("Token validaton failed.", tokenNotValid.getMessage());
	}
	/*
     * checking for invalid token null message. 
     * */
	@Test
	public void testInvalidToken() {
		InvalidTokenException tokenNotValid = new InvalidTokenException();
		assertEquals(null, tokenNotValid.getMessage());
	}

}
