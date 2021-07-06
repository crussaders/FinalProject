package com.PharmacySupply.AuthenticationService.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
/*************************************************************************
 * userTokenTest class is use to test the methods for userToken
 * class check weather method are working properly or not
 *************************************************************************/
public class userTokenTest {
	
	@Mock
	private UserToken utoken;
	/*
	 * intailSetup method is used to setup the initial setup before executing any test cases
	 */
	@Before
	public void IntialSetUp() {
		utoken= new UserToken("848513","Token");
	}
	/*
	 * This method test the All Argument Constructor of UserToken class
	 */
	@Test
	public void TestAllArgConstructor() {
		UserToken userTokn=new UserToken("848513","Token");
		assertEquals("Token",userTokn.getAuthToken());
	}
	/*
	 * This method test the NO Argument Constructor of UserToken class
	 */
	@Test
	public void TestNoArgConstructor() {
		UserToken usr=new UserToken();
		assertEquals(usr,usr);
	}
	/*
	 * This method test the Setter methods of UserToken class
	 */
	@Test
	public void TestSetterMethods()
	{
		UserToken details = new UserToken();
		details.setUserId("848513");
		details.setAuthToken("token");
		assertEquals("848513",details.getUserId());
	}
	/*
	 * This method test the Equals method of UserToken class
	 */
	@Test
	public void TestEqualsMethod() {
		boolean res=utoken.equals(utoken);
		assertTrue(res);
	}
	/*
	 * This method test the HashCode method of UserToken class
	 */
	@Test
	public void TestHashCodeMethod()
	{
		int hashCode = utoken.hashCode();
		assertEquals(hashCode, utoken.hashCode());
	}
	/*
	 * This method test the ToString method of UserToken class
	 */
	@Test
	public void TestToStringmethod() {
		assertEquals("UserToken(userId=" + utoken.getUserId() + ", authToken=" + utoken.getAuthToken()
				+  ")", utoken.toString());	
	}
	
	
}
