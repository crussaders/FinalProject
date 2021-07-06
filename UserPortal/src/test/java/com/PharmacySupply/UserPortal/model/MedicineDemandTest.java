package com.PharmacySupply.UserPortal.model;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MedicineDemandTest {

	
	@Mock
	MedicineDemand demand;
	
	@BeforeEach
	void setUp() throws Exception {
		demand = new MedicineDemand();
		demand.setId(1);
		demand.setMedicineName("Crocin");
		demand.setDemandCount(10);
	}

	@Test
	void testSetter() {
		assertEquals(1,demand.getId());
	}
	
	@Test
	void testGetter() {
		demand.setMedicineName("Orthoherb");
		assertEquals("Orthoherb",demand.getMedicineName());
	}
	
	@Test
	void testNoArgsConstructor() {
		MedicineDemand demand = new MedicineDemand();
		assertEquals(null,demand.getMedicineName());
	}
	
	@Test
	public void testAllArgsConstructor() {
		MedicineDemand medicineDemand = new MedicineDemand(1,"Crocin",10);
		assertEquals(demand.getDemandCount(),medicineDemand.getDemandCount());
	}

}
