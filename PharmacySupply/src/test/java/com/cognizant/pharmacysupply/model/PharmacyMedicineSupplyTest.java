package com.cognizant.pharmacysupply.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This Class checks the methods of the MedicineSupplyTest Pojo Class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PharmacyMedicineSupplyTest {

	@Mock
	PharmacyMedicineSupply supply;
	
	/**
	 * Method Name --> setup
	 * Before running test cases this method should run to set the value for fields.
	 * @throws Exception
	 */
	@Before
	public void Setup() {
		supply = new PharmacyMedicineSupply();
		supply.setId(1);
		supply.setMedicineName("Crocin");
		supply.setPharmacyName("Healthy Pharmacy");
		supply.setSupplyCount(10);
	}
	
	/**
	 * Method Name -->  testSetter
	 * This method  testSetter checks the setter method returned by the Medicine Stock.
	 */
	@Test
	public void testSetters() {
		supply.setId(1);
		supply.setMedicineName("Orthoherb");
		assertEquals("Orthoherb", supply.getMedicineName());
	}
	/**
	 * Method Name -->  testGetter
	 * This method  testGetter checks the getter method returned by the Medicine Stock.
	 */
	@Test
	public void testGetters() {
		assertEquals("Crocin", supply.getMedicineName());
	}
	/**
	 * Method Name --> testNoArgsConstructor
	 * This method checks the Medicine Stock with no argument.
	 */
	@Test
	public void NoArgsConstructorTest() {
		PharmacyMedicineSupply supply = new PharmacyMedicineSupply();
		assertEquals(null, supply.getMedicineName());
	}
	/**
	 * Method Name --> testAllArgsConstructor
	 * This method checks the Medicine Stock with all argument.
	 */
	@Test
	public void AllArgConstTest() {
		PharmacyMedicineSupply supply = new PharmacyMedicineSupply(1, "Healthy Pharmacy", "Crocin", 10);
		assertEquals("Crocin", supply.getMedicineName());
		assertEquals("Healthy Pharmacy", supply.getPharmacyName());

	}
	/**
	 * Method Name --> testToStringMethod
	 * This method testToStringMethod checks the to string method returned by the Medicine Stock.
	 */
	@Test
	public void testToString() {
		assertEquals(
				"PharmacyMedicineSupply(id=" + supply.getId() + ", pharmacyName=" + supply.getPharmacyName()
						+ ", medicineName=" + supply.getMedicineName() + ", supplyCount=" + supply.getSupplyCount() + ")",
				supply.toString());
	}

}
