package com.cognizant.pharmacysupply.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  This Class checks for the TokenValidationFailedException class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenValidationFailedExceptionTest {

	@Mock
	private TokenValidationFailedException tokenValidationFailedException;
	
	/**
	 * Method Name --> testOneArgConstructor
	 * This method checks the TokenValidationFailedException with one argument.
	 */
	@Test
	public void testOneArgConstructor() {
		TokenValidationFailedException medicineNotFoundException = new TokenValidationFailedException(
				"Token validation failed.");
		assertEquals("Token validation failed.", medicineNotFoundException.getMessage());
	}
	
	/**
	 * Method Name --> testNoArgsConstructor
	 * This method checks the TokenValidationFailedException with no argument.
	 */
	@Test
	public void testNoArgsConstructor() {
		TokenValidationFailedException exception = new TokenValidationFailedException();
		assertEquals(null, exception.getMessage());
	}

}
