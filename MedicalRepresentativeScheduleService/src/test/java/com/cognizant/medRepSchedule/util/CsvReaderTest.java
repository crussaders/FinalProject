package com.cognizant.medRepSchedule.util;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.medRepSchedule.exception.InvalidTokenException;
import com.cognizant.medRepSchedule.model.Doctor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CsvReaderTest {

	@Mock
	public CsvReader csvReader;

	/*
	 * Checking the mocked list of doctor from csvReader is not empty 
	 * */
	@Test
	void testParseDoctors() throws InvalidTokenException {

		log.info("Start");

		List<Doctor> doctors = CsvReader.parseDoctor();
		assertNotNull(doctors);
		log.info("End");

	}

}
