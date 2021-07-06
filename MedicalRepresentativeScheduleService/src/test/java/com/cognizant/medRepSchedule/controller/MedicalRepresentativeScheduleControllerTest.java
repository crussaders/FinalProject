package com.cognizant.medRepSchedule.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cognizant.medRepSchedule.exception.InvalidDateException;
import com.cognizant.medRepSchedule.exception.InvalidTokenException;
import com.cognizant.medRepSchedule.feignClient.AuthenticationFeignClient;
import com.cognizant.medRepSchedule.model.Doctor;
import com.cognizant.medRepSchedule.model.Representative;
import com.cognizant.medRepSchedule.model.RepresentativeSchedule;
import com.cognizant.medRepSchedule.service.MedicalRepresentativeSheduleServiceImpl;
import com.cognizant.medRepSchedule.service.RepresentativeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MedicalRepresentativeScheduleControllerTest {

	@Mock
	public MedicalRepresentativeController medRepController;

	@Mock
	public AuthenticationFeignClient authFeignClient;

	@Mock
	public RepresentativeServiceImpl repService;

	@Mock
	public MedicalRepresentativeSheduleServiceImpl medRepScheduleService;

	/*
	 * check list of doctor isn't empty
	 */
	@Test
	void testGetDoctors() throws InvalidTokenException {

		log.info("Start");

		List<Doctor> doctors = medRepController.getDoctors();
		assertNotNull(doctors);
		log.info("End");

	}

	/*
	 * when token is passed ("test") then return true check list of medical
	 * representative isn't empty
	 */
	@Test
	void testGetMedicalRepresentatives() throws InvalidTokenException {

		log.info("Start");
		when(medRepController.isValidSession("test")).thenReturn(true);
		List<Representative> medicalRepresentatives = repService.getMedicalRepresentatives("test");
		assertNotNull(medicalRepresentatives);

		log.info("End");

	}

	/*
	 * when token is passed ("test") then return true check list of medical
	 * representative schedule list isn't empty
	 */
	@Test
	void testGetRepresentativeSchedule() throws InvalidDateException, InvalidTokenException {
		log.info("Start");
		when(medRepController.isValidSession("test")).thenReturn(true);

		List<RepresentativeSchedule> medicalRepresentativesScheduleList = medRepScheduleService
				.getRepresentativesSchedule("test", LocalDate.now());
		assertNotNull(medicalRepresentativesScheduleList);

		log.info("End");
	}

	/*
	 * when token is passed ("test") then return true
	 **/
	@Test
	void testIsValidSession() throws InvalidTokenException {

		log.info("Start");
		when(medRepScheduleService.isValidSession("test")).thenReturn(true);

		assertEquals(true, medRepScheduleService.isValidSession("test"));
		log.info("End");

	}

}
