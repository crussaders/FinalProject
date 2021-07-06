package com.cognizant.medRepSchedule.modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medRepSchedule.model.JwtResponse;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
public class JwtResponseTest {

	@Mock
	JwtResponse jwtResponse;

	@Before
	public void setUp() throws Exception {
		log.info("Start");
		jwtResponse = new JwtResponse("admin", true);
		log.info("End");
	}

	@Test
	public void testAuthResponseDetails() throws Exception {
		log.info("Start");
		assertEquals("admin", jwtResponse.getUserid());
		assertEquals(true, jwtResponse.isValid());
		log.info("End");
	}

	@Test
	public void testNoArgsConstructor() {
		log.info("Start");
		JwtResponse authResponse = new JwtResponse();
		assertEquals(authResponse, authResponse);
		log.info("End");
	}

	@Test
	public void testSetters() {
		jwtResponse.setUserid("Rock");
		jwtResponse.setValid(true);
		assertEquals("Rock", jwtResponse.getUserid());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = jwtResponse.equals(jwtResponse);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = jwtResponse.hashCode();
		assertEquals(hashCode, jwtResponse.hashCode());
	}

	@Test
	public void testToStringMethod() {
		JwtResponse authResponse = new JwtResponse();
		assertEquals(authResponse.toString(), authResponse.toString());

	}

}
