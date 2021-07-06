package com.cognizant.medRepSchedule.modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.medRepSchedule.model.Representative;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class RepresentativeTest {

	@Mock
	Representative medicalRepresentative = new Representative();

	//Checking for setter and getter methods using equals
	@Test
	void testSettersAndGetter() {
		log.info("Start");
		Representative medicalRepresentative = new Representative();
		medicalRepresentative.setName("Representative 1");
		medicalRepresentative.setId(1);
		assertEquals(1, medicalRepresentative.getId());
		assertEquals("Representative 1", medicalRepresentative.getName());

		log.info("End");

	}
    //test all argument constructor
	@Test
	void testAllArgsConstructor() {
		log.info("Start");
		Representative medicalRepresentative = new Representative(1, "Representative 1");
		assertEquals(1, medicalRepresentative.getId());
		assertEquals("Representative 1", medicalRepresentative.getName());
		log.info("End");

	}
	
    //test equals method
	@Test
	void testEqualsMethod() {
		boolean equals = medicalRepresentative.equals(medicalRepresentative);
		assertTrue(equals);
	}

	@Test
	void testHashCodeMethod() {
		int hashCode = medicalRepresentative.hashCode();
		assertEquals(hashCode, medicalRepresentative.hashCode());
	}

	@Test
	void testToStringMethod() {
		log.info("Start");
		medicalRepresentative = new Representative();
		assertEquals(medicalRepresentative.toString(), medicalRepresentative.toString());
		log.info("End");
	}

}
