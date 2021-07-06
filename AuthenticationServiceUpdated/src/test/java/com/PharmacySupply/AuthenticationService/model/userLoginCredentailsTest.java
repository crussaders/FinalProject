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
 * userLoginCredentailsTest class is use to test the methods for userLoginCredentails
 * class check weather method are working properly or not
 *************************************************************************/
public class userLoginCredentailsTest {

	@Mock
	private UserLoginCredentials login;
	
	/*
	 * intailSetup method is used to setup the initial setup before executing any test cases
	 */
	@Before
	public void IntialSetUp()
	{
		login= new UserLoginCredentials("848513","admin");
	}
	/*
	 * This method test the All Argument Constructor of UserLoginCredentials class
	 */
	@Test
	public void TestAllArgConstructor() {
		UserLoginCredentials userLog =new UserLoginCredentials("848513","admin");
		assertEquals("848513",userLog.getUserid());
	}
	/*
	 * This method test the Equals method of UserLoginCredentials class
	 */
	@Test
	public void TestEqualsMethod() {
		boolean res=login.equals(login);
		assertTrue(res);
	}
	/*
	 * This method test the NO Argument Constructor of UserLoginCredentials class
	 */
	@Test
	public void TestNoArgConstructor(){
		UserLoginCredentials ulc=new UserLoginCredentials();
		assertEquals(ulc,ulc);
	}
	/*
	 * This method test the Setter methods of UserLoginCredentials class
	 */
	@Test
	public void TestSetterMethods()
	{
		UserLoginCredentials details = new UserLoginCredentials();
		details.setUserid("848513");
		details.setPassword("sagar123");
		assertEquals("848513",details.getUserid());
	}
	/*
	 * This method test the ToString method of UserLoginCredentials class
	 */
	@Test
	public void TestToStringmethod() {
		UserLoginCredentials userLoginCredentials = new UserLoginCredentials("848513","admin");
		assertEquals("UserLoginCredentials(userid=" + userLoginCredentials.getUserid() + ", password=" + userLoginCredentials.getPassword()
				+  ")",userLoginCredentials.toString());	
	}
	/*
	 * This method test the HashCode method of UserLoginCredentials class
	 */
	@Test
	public void TestHashCodeMethod()
	{
		int hashCode = login.hashCode();
		assertEquals(hashCode, login.hashCode());
	}
}
