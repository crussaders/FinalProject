package com.cognizant.pharmacysupply.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This Class checks the methods of the ErrorResponse Pojo Class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorResponseTest {
	@Mock
	private ErrorResponse ErrorResponse;

	/**
	 * Method Name --> setup
	 * Before running test cases this method should run to set the value for fields.
	 */
	@Before
	public void setup() {

		ErrorResponse = new ErrorResponse();
		ErrorResponse.setStatus(HttpStatus.OK);
		ErrorResponse.setReason("Bad request");
		ErrorResponse.setMessage("Please provide valid value");

	}
	
	/**
	 * Method Name --> testMedicineStockDetails
	 * @throws Exception
	 * This method testMedicineStockDetails checks the status,reason and message which has setted
	 * in setup method.
	 */
	@Test
	public void testMedicineStockDetails() throws Exception {

		assertEquals(HttpStatus.OK, ErrorResponse.getStatus());
		assertEquals("Bad request", ErrorResponse.getReason());
		assertEquals("Please provide valid value", ErrorResponse.getMessage());

	}
	
	/**
	 * Method Name --> testAllArgsConstructor
	 * This method testAllArgsConstructor Error Response with all arguments.
	 */
	@Test
	public void testAllArgsConstructor() {
		ErrorResponse ErrorResponse = new ErrorResponse(null, HttpStatus.OK, "Bad request",
				"Please provide valid value");
		assertEquals("Bad request", ErrorResponse.getReason());
	}
	
	/**
	 * Method Name --> testToStringMethod
	 * This method testToStringMethod checks the to string method returned by the Error Response.
	 */
	@Test
	public void testToStringMethod() {

		assertEquals(
				"ErrorResponse(timestamp=" + ErrorResponse.getTimestamp() + ", status=" + ErrorResponse.getStatus()
						+ ", reason=" + ErrorResponse.getReason() + ", message=" + ErrorResponse.getMessage() + ")",
				ErrorResponse.toString());

	}
	
	/**
	 * Method Name -->  testEqualsMethod
	 * This method  testEqualsMethod checks the equals method returned by the Error Response.
	 */
	@Test
	public void testEqualsMethod() {
		boolean equals = ErrorResponse.equals(ErrorResponse);
		assertTrue(equals);
	}
	
	/**
	 * Method Name -->  testHashCodeMethod
	 * This method  testHashCodeMethod checks the hashCode method returned by the Error Response.
	 */
	@Test
	public void testHashCodeMethod() {
		int hashCode = ErrorResponse.hashCode();
		assertEquals(hashCode, ErrorResponse.hashCode());
	}
	
	/**
	 * Method Name -->  testSetterMethod
	 * This method  testSetterMethod checks the setter method returned by the Error Response.
	 */
	@Test
	public void testSetterMethod() {
		ErrorResponse.setMessage("Hello");
		ErrorResponse.setReason("BAD REQUEST");
		ErrorResponse.setStatus(HttpStatus.OK);
		ErrorResponse.setTimestamp(null);
		assertEquals("Hello", ErrorResponse.getMessage());
	}

}
