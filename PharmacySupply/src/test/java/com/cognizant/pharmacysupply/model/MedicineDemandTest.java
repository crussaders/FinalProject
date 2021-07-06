package com.cognizant.pharmacysupply.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This Class checks the methods of the MedicineDemandTest Pojo Class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MedicineDemandTest {

	@Mock
	MedicineDemand demand;
	
	/**
	 * Method Name --> setup
	 * Before running test cases this method should run to set the value for fields.
	 * @throws Exception
	 */
	@Before
	public void setup() {
		
		demand = new MedicineDemand();
		demand.setId(1);
		demand.setMedicineName("Crocin");
		demand.setDemandCount(10);
	}
	
	/**
	 * Method Name -->  testSetter
	 * This method  testSetter checks the setter method returned by the Medicine Demand.
	 */
	@Test
	public void testSetter() {
		assertEquals(1, demand.getId());
	}
	/**
	 * Method Name -->  testGetter
	 * This method  testGetter checks the getter method returned by the Medicine Demand.
	 */
	@Test
	public void testGetter() {
		demand.setMedicineName("Orthoherb");
		assertEquals("Orthoherb", demand.getMedicineName());
	}
	
	/**
	 * Method Name --> testNoArgsConstructor
	 * This method checks the Medicine Demand with no argument.
	 */
	@Test
	public void testNoArgsConstructor() {
		MedicineDemand demand = new MedicineDemand();
		assertEquals(null, demand.getMedicineName());
	}
	/**
	 * Method Name --> testAllArgsConstructor
	 * This method checks the Medicine Demand with all argument.
	 */
	@Test
	public void testAllArgsConstructor() {
		MedicineDemand medicineDemand = new MedicineDemand(1, "Crocin", 10);
		assertEquals(demand.getDemandCount(),medicineDemand.getDemandCount());
	}
	/**
	 * Method Name --> testToStringMethod
	 * This method testToStringMethod checks the to string method returned by the Medicine Demand.
	 */
	@Test
	public void testToStringMethod() {
	assertEquals("MedicineDemand(id=" + demand.getId() + ", medicineName=" + demand.getMedicineName() + ", demandCount=" + demand.getDemandCount()
				 + ")",demand.toString());
	}
	
}
