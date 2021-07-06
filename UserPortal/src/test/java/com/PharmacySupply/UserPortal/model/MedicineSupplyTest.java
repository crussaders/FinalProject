package com.PharmacySupply.UserPortal.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MedicineSupplyTest {

	@Mock
	MedicineSupply medicineSupply;
	
	@BeforeEach
	public void setUp() throws Exception {
		medicineSupply = new MedicineSupply();
		medicineSupply.setId(1);
		medicineSupply.setPharmacyName("Generation Pharmacy");
		medicineSupply.setMedicineName("Remdesivir");
		medicineSupply.setSupplyCount(300);
	}

	@Test
	public void testSetters() {
		medicineSupply.setId(1);
		medicineSupply.setPharmacyName("Best Care Pharmacy");
		assertEquals("Best Care Pharmacy",medicineSupply.getPharmacyName());
	}
	
	@Test
	public void testGetters( ) {
		assertEquals("Generation Pharmacy",medicineSupply.getPharmacyName());
	}
	
	@Test
	public void NoArgsConstructor() {
		MedicineSupply medicineSupply = new MedicineSupply();
		assertEquals(null, medicineSupply.getPharmacyName());
		
	}
	
	@Test
	public void AllArgConstTest() {
		MedicineSupply supply = new MedicineSupply(1,"Generation Pharmacy","Remdesivir",300);
		assertEquals("Generation Pharmacy",supply.getPharmacyName());
		assertEquals(medicineSupply.getMedicineName(),supply.getSupplyCount());
		
	}
	
	

}
