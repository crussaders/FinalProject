package com.cognizant.pharmacysupply.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This Class checks the methods of the MedicineStockTest Pojo Class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MedicineStockTest {

	@Mock
	MedicineStock medicineStock;

	/**
	 * Method Name --> setup
	 * Before running test cases this method should run to set the value for fields.
	 * @throws Exception
	 */
	@Before
	public void setUp()  {
		medicineStock = new MedicineStock();
		medicineStock.setId(1);
		medicineStock.setName("Crocin");
		medicineStock.setChemicalComposition("digoxin");
		medicineStock.setPharmacyName("Healthy Pharmacy");
		medicineStock.setTargetAilment("Cardiac Arrest");
		medicineStock.setNumberOfTabletsInStock(10);
		medicineStock.setDateOfExpiry(new Date(2022 - 9 - 12));
	}
	/**
	 * Method Name -->  testSetter
	 * This method  testSetter checks the setter method returned by the Medicine Stock.
	 */
	@Test
	public void testSetters() {
		medicineStock.setId(1);
		medicineStock.setName("Orthoherb");
		assertEquals("Orthoherb", medicineStock.getName());
	}
	/**
	 * Method Name -->  testGetter
	 * This method  testGetter checks the getter method returned by the Medicine Stock.
	 */
	@Test
	public void testGetters() {
		assertEquals("Crocin", medicineStock.getName());
	}
	/**
	 * Method Name --> testNoArgsConstructor
	 * This method checks the Medicine Stock with no argument.
	 */
	@Test
	public void NoArgsConstructorTest() {
		MedicineStock medicineStock = new MedicineStock();
		assertEquals(null, medicineStock.getPharmacyName());
	}
	/**
	 * Method Name --> testAllArgsConstructor
	 * This method checks the Medicine Stock with all argument.
	 */
	@Test
	public void AllArgConstTest() {
		MedicineStock stock = new MedicineStock(1, "Crocin", "digoxin", "General", "Healthy Pharmacy",
				new Date(2022 - 9 - 12), 10);
		assertEquals("Crocin", stock.getName());
		assertEquals(medicineStock.getNumberOfTabletsInStock(), stock.getNumberOfTabletsInStock());
	}
	/**
	 * Method Name --> testToStringMethod
	 * This method testToStringMethod checks the to string method returned by the Medicine Stock.
	 */
	@Test
	public void testToString() {
		assertEquals("MedicineStock(id=" + 1 + ", name=" + medicineStock.getName() + ", chemicalComposition=" + medicineStock.getChemicalComposition()
				+ ", targetAilment=" + medicineStock.getTargetAilment() + ", pharmacyName=" + medicineStock.getPharmacyName() + ", dateOfExpiry="
				+ medicineStock.getDateOfExpiry() + ", numberOfTabletsInStock=" + medicineStock.getNumberOfTabletsInStock() + ")", medicineStock.toString());
	}

}
