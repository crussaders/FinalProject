package com.cognizant.medicinestock.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
/* This ErrorResponseTest class tests for getters, setters, all args constructor methods */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorResponseTest {

	@Mock
	private ErrorResponse ErrorResponse;
 /* This setup methods runs first before testing the actual methods,setting the values */
	@Before
	public void setup() {

		ErrorResponse = new ErrorResponse();
		ErrorResponse.setStatus(HttpStatus.OK);
		ErrorResponse.setReason("Bad request");
		ErrorResponse.setMessage("Please provide valid value");

	}
  /* This testMedicineStockDetails method tests for data annotation when exception is thrown and 
   checks with the actual messages same or not
   Input Parameter->status code,message,reason ,Output Parameter->status code,message,reason  */
	@Test
	public void testMedicineStockDetails() throws Exception {

		assertEquals(HttpStatus.OK, ErrorResponse.getStatus());
		assertEquals("Bad request", ErrorResponse.getReason());
		assertEquals("Please provide valid value", ErrorResponse.getMessage());

	}
/* In this testAllArgsConstructor method, we provide all the arguments and this checks with the actual arguments 
 * Input Parameters->providing the error response values, Output Parameter->getting the actual values*/
	@Test
	public void testAllArgsConstructor() {
		ErrorResponse ErrorResponse = new ErrorResponse(null, HttpStatus.OK, "Bad request",
				"Please provide valid value");
		assertEquals("Bad request", ErrorResponse.getReason());
	}

	/* In this testToStringMethod method, we are fetching the data and printing them
	 * Input Parameters->getting the data from pojo class, Output Parameters->print all the values */ 
	@Test
	public void testToStringMethod() {

		assertEquals(
				"ErrorResponse(localDateTime=" + ErrorResponse.getLocalDateTime() + ", status=" + ErrorResponse.getStatus()
						+ ", reason=" + ErrorResponse.getReason() + ", message=" + ErrorResponse.getMessage() + ")",
				ErrorResponse.toString());

	}
 /* This methods checks whether both the values true or not
  * Input Parameter->true, Output Parameter->true */
	@Test
	public void testEqualsMethod() {
		boolean equals = ErrorResponse.equals(ErrorResponse);
		assertTrue(equals);
	}

	

	/* This  testSetterMethod methods checks for setters
	 * Input Parameters->setting the values for Error Response like Hello,BAD REQUEST, HttpStatus.OK,null , Output Parameters->Hello*/
	@Test
	public void testSetterMethod() {
		ErrorResponse.setMessage("Hello");
		ErrorResponse.setReason("BAD REQUEST");
		ErrorResponse.setStatus(HttpStatus.OK);
		ErrorResponse.setLocalDateTime(null);
		assertEquals("Hello", ErrorResponse.getMessage());
	}

}
