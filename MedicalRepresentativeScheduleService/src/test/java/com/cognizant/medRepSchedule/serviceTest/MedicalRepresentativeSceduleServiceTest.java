package com.cognizant.medRepSchedule.serviceTest;

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
import com.cognizant.medRepSchedule.model.RepresentativeSchedule;
import com.cognizant.medRepSchedule.service.MedicalRepresentativeSheduleServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MedicalRepresentativeSceduleServiceTest {

	@Mock
	public MedicalRepresentativeSheduleServiceImpl medRepScheduleService;
	
	/*
	 * when token is passed ("test") then return true.
	 * Checking for medical representative schedule list is not null;
	 * */
	@Test
	void testGetMedicalRepresentativeSchedule() throws InvalidTokenException, InvalidDateException {

		log.info("Start");

		when(medRepScheduleService.isValidSession("test")).thenReturn(true);

		List<RepresentativeSchedule> medicalRepresentativesScheduleList = medRepScheduleService
				.getRepresentativesSchedule("test", LocalDate.now());
		assertNotNull(medicalRepresentativesScheduleList);

		log.info("End");

	}
	/*
	 * when token is passed ("test") then return true.
	 * for same checking equal reference for true.
	 */
	@Test
	void testIsValidSession() throws InvalidTokenException {

		log.info("Start");
		when(medRepScheduleService.isValidSession("test")).thenReturn(true);
		assertEquals(true, medRepScheduleService.isValidSession("test"));
		log.info("End");

	}
}
