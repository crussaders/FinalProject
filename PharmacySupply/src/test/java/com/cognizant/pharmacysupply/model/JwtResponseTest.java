package com.cognizant.pharmacysupply.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This Class checks the methods of the JwtResponse Pojo Class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtResponseTest {

	@Mock
	public JwtResponse response;
	
	/**
	 * Method Name --> setup
	 * Before running test cases this method should run to set the value for fields.
	 */
	@Before
	public void setUp() {
		response=new JwtResponse();
		response.setUserid("admin");
		response.setValid(false);
	}
	
	/**
	 * Method Name --> AllArgConstTest
	 * This method testAllArgConstTest JWT Response with all arguments.
	 */
	@Test
	public void testAllArgConstTest() {
		JwtResponse auth=new JwtResponse("admin",false);
		assertEquals("admin", auth.getUserid());
		}
	
	/**
	 * Method Name --> testToStringMethod
	 * This method testToStringMethod checks the to string method returned by the JWT Response.
	 */
	@Test
	public void testToStringMethod() {
	assertEquals("JwtResponse(userid=" + response.getUserid() 
				+ ", valid=" + response.isValid() + ")",response.toString());
	}
	
	
	/**
	 * Method Name --> testNoArgsConstructor
	 * This method testNoArgsConstructor JWT Response with all arguments.
	 */
	@Test
	public void testNoArgsConstructor() {
		
		JwtResponse response = new JwtResponse();
		assertEquals(null, response.getUserid());
	}	

	/**
	 * Method Name -->  testSetters
	 * This method  testSetters checks the setter method returned by the JWT Response.
	 */
	@Test
	public void testSetters() {
		response.setUserid("admin");
		response.setValid(true);
		assertEquals("admin", response.getUserid());
	}
	
	/**
	 * Method Name -->  testEqualsMethod
	 * This method  testEqualsMethod checks the equals method returned by the JWT Response.
	 */
	@Test
	public void testEqualsMethod() {
		boolean equals = response.equals(response);
		assertTrue(equals);
	}
	
	/**
	 * Method Name -->  testHashCodeMethod
	 * This method  testHashCodeMethod checks the hashCode method returned by the JWT Response.
	 */
	@Test
	public void testHashCodeMethod() {
		int hashCode = response.hashCode();
		assertEquals(hashCode, response.hashCode());
	}
}
