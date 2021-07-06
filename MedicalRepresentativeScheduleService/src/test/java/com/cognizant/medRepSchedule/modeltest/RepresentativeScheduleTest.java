package com.cognizant.medRepSchedule.modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.medRepSchedule.model.RepresentativeSchedule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class RepresentativeScheduleTest {

	@Mock
	RepresentativeSchedule repSchedule;

	String[] medicines = { "COVAXIN", "COVISHIELD" };

	@Test
	void testSettersAndGetter() {
		log.info("Start");
		RepresentativeSchedule repSchedule = new RepresentativeSchedule();

		repSchedule.setId(1);
		assertEquals(1, repSchedule.getId());

		repSchedule.setRepresentativeName("R1");
		repSchedule.setDoctorName("D1");
		repSchedule.setMeetingSlot("1 to 2 PM");
		repSchedule.setMeetingDate(LocalDate.now());
		repSchedule.setDoctorContactNumber("9098318902");
		repSchedule.setMedicines(medicines);
		repSchedule.setTreatingAilment("COVID-19");
		assertEquals("R1", repSchedule.getRepresentativeName());
		assertEquals("D1", repSchedule.getDoctorName());
		assertEquals("1 to 2 PM", repSchedule.getMeetingSlot());
		assertEquals(LocalDate.now(), repSchedule.getMeetingDate());
		assertEquals("9098318902", repSchedule.getDoctorContactNumber());

		assertNotNull(repSchedule.getMedicines());
		assertEquals("COVID-19", repSchedule.getTreatingAilment());

		log.info("End");

	}

	@Test
	void testEqualsMethod() {
		RepresentativeSchedule repSchedule = new RepresentativeSchedule();
		boolean equals = repSchedule.equals(repSchedule);
		assertTrue(equals);
	}

	@Test
	void testHashCodeMethod() {
		RepresentativeSchedule repSchedule = new RepresentativeSchedule();
		int hashCode = repSchedule.hashCode();
		assertEquals(hashCode, repSchedule.hashCode());
	}

	@Test
	void testToStringMethod() {
		log.info("Start");
		RepresentativeSchedule repSchedule = new RepresentativeSchedule();
		assertEquals(repSchedule.toString(), repSchedule.toString());
		log.info("End");
	}

}
