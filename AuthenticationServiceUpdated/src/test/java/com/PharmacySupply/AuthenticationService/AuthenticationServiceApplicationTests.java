package com.PharmacySupply.AuthenticationService;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthenticationServiceApplicationTests {

	@Mock
	AuthenticationServiceApplication application;
	
	/*
	 * This method test the instance of AuthenticationServiceApplication
	 */
	@Test
	public void TestcontextLoads() {
		assertNotNull(application);
	}
}
