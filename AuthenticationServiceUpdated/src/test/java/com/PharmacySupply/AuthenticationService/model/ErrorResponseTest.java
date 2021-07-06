package com.PharmacySupply.AuthenticationService.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/**********************************************************************
 * ErrorResponseTest class is use to test the methods for ErrorResponse
 * class check weather method are working properly or not
 **********************************************************************/
public class ErrorResponseTest {

	@Mock
	private ErrorResponse response;
	
	/*
	 * intailSetup method is used to setup the initial setup before executing any test cases
	 */
	@Before
	public void IntialSetup()
	{ 
		response=new ErrorResponse();
		response.setStatus(HttpStatus.OK);
		response.setDatetime(LocalDateTime.parse("2017-01-13T17:09:42.411"));
		response.setMessage("Bad Credentials");
		response.setDescription("Please provide valid value");
	}
	/*
	 * This method test the All Argument Constructor of ErrorResponse class
	 */
	@Test
	public void TestAllArgConstructor()
	{
		ErrorResponse response = new ErrorResponse(HttpStatus.OK,"Bad Credentials","Please provide valid value",LocalDateTime.now());
		assertEquals("Bad Credentials", response.getMessage());
	}
	/*
	 * This method test the NO Argument Constructor of ErrorResponse class
	 */
	@Test
	public void TestNoArgConstructor()
	{
		ErrorResponse errorResponse = new ErrorResponse();
		assertEquals(errorResponse, new ErrorResponse());
	}
	/*
	 * This method test the ToString method of ErrorResponse class
	 */
	@Test
	public void TestToString()
	{
		ErrorResponse response2 = new ErrorResponse(HttpStatus.OK,"Bad Credentials","Please provide valid value",LocalDateTime.parse("2017-01-13T17:09:42.411"));
		assertEquals(response.toString(),response2.toString());
	}
	/*
	 * This method test the Equals method of ErrorResponse class
	 */
	@Test
	public void TestEqualsMethod() {
		boolean equals = response.equals(response);
		assertTrue(equals);
	}
	/*
	 * This method test the HashCode method of ErrorResponse class
	 */
	@Test
	public void TestHashCodeMethod() {
		int hashCode = response.hashCode();
		assertEquals(hashCode, response.hashCode());
	}
	/*
	 * This method test the Setter methods of ErrorResponse class
	 */
	@Test
	public void TestSetterMethods() {
		response.setDescription("Hello");
		response.setMessage("BAD REQUEST");
		response.setStatus(HttpStatus.OK);
		response.setDatetime(null);
		assertEquals("BAD REQUEST", response.getMessage());
	}
}
