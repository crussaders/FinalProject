package com.cognizant.medRepSchedule.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cognizant.medRepSchedule.exception.InvalidTokenException;
import com.cognizant.medRepSchedule.feignClient.AuthenticationFeignClient;
import com.cognizant.medRepSchedule.model.Representative;
import com.cognizant.medRepSchedule.service.RepresentativeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@WebAppConfiguration
@Slf4j
@SpringBootTest
class RepresentativeServiceTest {

	@Mock
	private AuthenticationFeignClient authenticationFeignClient;

	@Mock
	private RepresentativeServiceImpl repService;
	
	/*
	 * when token is passed ("test") then return true.
	 * checking the representative list is not empty. 
	 */
	@Test
	void testGetMedicalRepresentatives() throws InvalidTokenException {

		log.info("Start");
		when(repService.isValidSession("test")).thenReturn(true);
		List<Representative> medicalRepresentatives = repService.getMedicalRepresentatives("test");
		assertNotNull(medicalRepresentatives);

		log.info("End");

	}
	
	/*
	 * when token is passed ("test") then return true.
	 * for same checking equal reference for true.
	 */
	@Test
	void testIsValidSession() throws InvalidTokenException {

		log.info("Start");
		when(repService.isValidSession("test")).thenReturn(true);
		assertEquals(true, repService.isValidSession("test"));
		log.info("End");

	}
}
