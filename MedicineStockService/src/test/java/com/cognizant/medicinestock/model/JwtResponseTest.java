package com.cognizant.medicinestock.model;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/* This JwtResponseTest class tests for getters, setters, all args constructor methods */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtResponseTest {

	@Mock
	public JwtResponse response;
	/* This setup methods runs first before testing the actual methods,setting the values */
	@Before
	public void setUp() throws Exception{
		response=new JwtResponse();
		response.setUserid("admin");
		
		response.setValid(false);
	}
	/* In this AllArgConstTest method, we provide all the arguments and this checks with the actual arguments
	 * Input Parameters->admin,false through getters getting values, Output Parameters->admin */
	
	@Test
	public void AllArgConstTest() {
		JwtResponse auth=new JwtResponse("admin",false);
		
		assertEquals("admin", auth.getUserid());
		}
	/* In this testToStringMethod method, we are fetching the data and printing them 
	 * Input Parameters->getting all the values ,Output Parameters->printing all the values */ 
	
	@Test
	public void testToStringMethod() {
	assertEquals("JwtResponse(userid=" + response.getUserid() + 
				 ", valid=" + response.isValid() + ")",response.toString());
	}
	
	/* This testNoArgsConstructor methods for no arguments and getting null as output
	 * Input Parameters->getUserid, Output Parameters->null */ 
	@Test
	public void testNoArgsConstructor() {
		
		JwtResponse response = new JwtResponse();
		assertEquals(null, response.getUserid());
	}
	
	/* This  testSetters methods checks for setters
	 * Input Parameters->admin, true, Output Parameters-> admin */
	@Test
	public void testSetters() {
		
		response.setUserid("admin");
		response.setValid(true);
		assertEquals("admin", response.getUserid());
	}
	
	/* This testEqualsMethod method checks whether both the values true or not 
	 * Input Parameters->true, Output Parameters->true*/
	@Test
	public void testEqualsMethod() {
		boolean equals = response.equals(response);
		assertTrue(equals);
	}
 /* ThistestHashCodeMethod method checks whether both the hash codes are same or not
  * Input Parameters->hash code, Output Parameters->hash code */ 
	@Test
	public void testHashCodeMethod() {
		int hashCode = response.hashCode();
		assertEquals(hashCode, response.hashCode());
	}
	
}
