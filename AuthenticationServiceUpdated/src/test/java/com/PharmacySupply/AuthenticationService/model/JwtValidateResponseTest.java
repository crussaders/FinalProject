package com.PharmacySupply.AuthenticationService.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/*********************************************************************************
 * JwtValidateResponseTest class is use to test the methods for JwtValidateResponse
 * class check weather method are working properly or not
 **********************************************************************************/
public class JwtValidateResponseTest {

	@Mock
	public JwtValidateResponse response;
	
	/*
	 * intailSetup method is used to setup the initial setup before executing any test cases
	 */
	@Before
	public void IntialSetUp() {
		response=new JwtValidateResponse();
		response.setUserid("848513");
		response.setValid(false);
	}
	/*
	 * This method test the All Argument Constructor of JwtValidateResponse class
	 */
	@Test
	public void TestAllArgConstructor() {
		JwtValidateResponse auth=new JwtValidateResponse("848513",false);
		assertEquals("848513", auth.getUserid());
	}
	/*
	 * This method test the NO Argument Constructor of JwtValidateResponse class
	 */
	@Test
	public void TestNoArgConstructor()
	{
		JwtValidateResponse response = new JwtValidateResponse();
		assertEquals(response, new JwtValidateResponse());
	}
	
	/*
	 * This method test the ToString method of JwtValidateResponse class
	 */
	@Test
	public void TestToStringmethod()
	{
		assertEquals("JwtValidateResponse(userid=" + response.getUserid() + ", valid=" + response.isValid()+")", response.toString());
	}
	/*
	 * This method test the Setter methods of JwtValidateResponse class
	 */
	@Test
	public void TestSetterMethods() {
		response.setUserid("848513");
		response.setValid(true);
		assertEquals("848513", response.getUserid());
	}
	
	/*
	 * This method test the Equals method of JwtValidateResponse class
	 */
	@Test
	public void TestEqualsMethod() {
		boolean equals = response.equals(response);
		assertTrue(equals);
	}
	/*
	 * This method test the HashCode method of JwtValidateResponse class
	 */
	@Test
	public void TestHashCodeMethod() {
		int hashCode = response.hashCode();
		assertEquals(hashCode, response.hashCode());
	}
}
