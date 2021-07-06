package com.PharmacySupply.AuthenticationService.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/*************************************************************************
 * MyUserDetailsTest class is use to test the methods for MyUserDetails
 * class check weather method are working properly or not
 *************************************************************************/
public class MyUserDetailsTest {
	@Mock
	private MyUserDetails user;
	
	/*
	 * intailSetup method is used to setup the initial setup before executing any test cases
	 */
	@Before
	public void IntialSetUp()
	{
		user = new MyUserDetails("848513","Sagar Rathore","sagar123","sagar.rathore@cognizant.com","8979963619");
	}
	
	/*
	 * This method test the All Argument Constructor of MyUserDetails class
	 */
	@Test
	public void TestAllArgConstructor()
	{
		MyUserDetails userDetails = new MyUserDetails("848513","Sagar Rathore","sagar123","sagar.rathore@cognizant.com","8979963619");
		assertEquals(user.getUserid(),userDetails.getUserid());
		assertEquals(user.getName(), userDetails.getName());
		assertEquals(user.getPassword(), userDetails.getPassword());
		assertEquals(user.getEmail(), userDetails.getEmail());
		assertEquals(user.getNumber(), userDetails.getNumber());
	}
	/*
	 * This method test the NO Argument Constructor of MyUserDetails class
	 */
	@Test
	public void TestNoArgConstructor()
	{
		MyUserDetails details = new MyUserDetails();
		assertEquals(details,new MyUserDetails());
	}
	/*
	 * This method test the Setter methods of MyUserDetails class
	 */
	@Test
	public void TestSetterMethods()
	{
		MyUserDetails details = new MyUserDetails();
		details.setName("Sagar Rathore");
		details.setEmail("a@gmail.com");
		details.setNumber("9800000123");
		details.setPassword("sagar123");
		details.setUserid("897243");
		assertEquals(user.getName(),details.getName());
	}
	/*
	 * This method test the ToString method of MyUserDetails class
	 */
	@Test
	public void TestToStringmethod() {
		String expected="MyUserDetails(userid=" + user.getUserid() + ", name=" + user.getName() + ", password=" + user.getPassword() + ", email=" + user.getEmail()+ ", number=" + user.getNumber() + ")";
		assertEquals(expected, user.toString());	
	}
	/*
	 * This method test the Equals method of MyUserDetails class
	 */
	@Test
	public void TestEqualsMethod() {
		boolean equals = user.equals(user);
		assertTrue(equals);
	}
	/*
	 * This method test the HashCode method of MyUserDetails class
	 */
	@Test
	public void TestHashCodeMethod()
	{
		int hashCode = user.hashCode();
		assertEquals(hashCode, user.hashCode());
	}

}
