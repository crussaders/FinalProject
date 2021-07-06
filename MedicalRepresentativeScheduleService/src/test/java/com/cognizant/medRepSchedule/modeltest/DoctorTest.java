package com.cognizant.medRepSchedule.modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.medRepSchedule.model.Doctor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DoctorTest {

	@Mock
	public Doctor doctor;

	@Test
	void testSettersAndGetter() {
		log.info("Start");
		doctor = new Doctor();
		doctor.setName("D1");
		doctor.setContactNumber("9449569825");
		doctor.setTreatingAilment("General");
		doctor.setId(1);
		assertEquals(1, doctor.getId());

		assertEquals("D1", doctor.getName());
		assertEquals("9449569825", doctor.getContactNumber());
		assertEquals("General", doctor.getTreatingAilment());

		log.info("End");

	}

	@Test
	void testAllArgsConstructor() {
		Doctor doctor = new Doctor(1, "D1", "9449569825", "General");
		assertEquals("D1", doctor.getName());
		assertEquals("9449569825", doctor.getContactNumber());
		assertEquals("General", doctor.getTreatingAilment());
	}

	@Test
	void testToStringMethod() {
		log.info("Start");
		doctor = new Doctor();
		assertEquals(doctor.toString(), doctor.toString());
		log.info("End");
	}

	@Test
	void testEqualsMethod() {
		boolean equals = doctor.equals(doctor);
		assertTrue(equals);
	}

	@Test
	void testHashCodeMethod() {
		int hashCode = doctor.hashCode();
		assertEquals(hashCode, doctor.hashCode());
	}

}
