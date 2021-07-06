package com.cognizant.medicinestock.model;


import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.Test;
/* This MedicineStockTest class tests for getters and setters methods */
class MedicineStockTests {
	
	
MedicineStock medicineStock= new MedicineStock();
	
	/* This method tests for setter id attribute
	 * Input Parameter->4, OutputParameter->4 */
	@Test
	public void test_SetId() {
		medicineStock.setId(4);
		assertEquals(4,medicineStock.getId());
	}

	/* This method tests for getter id attribute
	 *  Input Parameter->4, OutputParameter->4 */
	@Test
	public void test_GetId() {
		medicineStock.setId(4);
		assertEquals(4, medicineStock.getId());

	}
	/* This method tests for setter PharmacyName attribute
	 *  Input Parameter->Generation Pharmacy , OutputParameter->Generation Pharmacy*/
	@Test
	public void test_SetPharmacyName() {
		medicineStock.setPharmacyName("Generation Pharmacy");
		assertEquals("Generation Pharmacy",medicineStock.getPharmacyName());
	}

	/* This method tests for getter PharmacyName attribute 
	 *  Input Parameter->Generation Pharmacy , OutputParameter->Generation Pharmacy*/
	@Test
	public void test_GetPharmacyName() {
		medicineStock.setPharmacyName("Generation Pharmacy");
		assertEquals("Generation Pharmacy", medicineStock.getPharmacyName());

	}
	/* This method tests for setter ChemicalComposition attribute
	 *  Input Parameter->Acetylsalicylic Acid , Cephalosporin, OutputParameter->Acetylsalicylic Acid , Cephalosporin */
	public void test_SetChemicalComposition() {
		medicineStock.setChemicalComposition("Acetylsalicylic Acid , Cephalosporin");
		assertEquals("Acetylsalicylic Acid , Cephalosporin",medicineStock.getChemicalComposition());
	}
	/* This method tests for getter ChemicalComposition attribute
	 *  Input Parameter->Paracetamol , Acetaminophen, OutputParameter->Paracetamol , Acetaminophen */
	@Test
	public void test_GetChemicalComposition() {
		medicineStock.setChemicalComposition("Paracetamol , Acetaminophen");
		assertEquals("Paracetamol , Acetaminophen", medicineStock.getChemicalComposition());

	}
	/* This method tests for setter Name attribute
	 *Input Parameters->Remdesivir, Output Parameters->Remdesivir */
	@Test
	public void test_SetName() {
		medicineStock.setName("Remdesivir");
		assertEquals("Remdesivir",medicineStock.getName());
	}
	/* This method tests for getter Name attribute
	 * Input Parameters->Remdesivir, Output Parameters->Remdesivir */
	@Test
	public void test_GetName() {
		medicineStock.setName("Remdesivir");
		assertEquals("Remdesivir", medicineStock.getName());

	}
	/* This method tests for setter TargetAilment attribute
	 * Input Parameters->Cardiology, Output Parameters->Cardiology */
	@Test
	public void test_SetTargetAilment() {
		medicineStock.setTargetAilment("Cardiology");
		assertEquals("Cardiology",medicineStock.getTargetAilment());
	}
	/* This method tests for getter TargetAilment attribute
	 * Input Parameters->Cardiology, Output Parameters->Cardiology  */
	@Test
	public void test_GetTargetAilment() {
		medicineStock.setTargetAilment("Cardiology");
		assertEquals("Cardiology", medicineStock.getTargetAilment());

	}
	/* This method tests for setter DateOfExpiry attribute 
	 * Input Parameters->2022 - 9 - 12, Output Parameters->2022 - 9 - 12*/
    @Test
	public void test_SetDateOfExpiry() {
		
		medicineStock.setDateOfExpiry(new java.util.Date(2022 - 9 - 12));
		assertEquals(new java.util.Date(2022 - 9 - 12),medicineStock.getDateOfExpiry());
	}

    /* This method tests for getter DateOfExpiry attribute
     * Input Parameters->2022 - 9 - 12, Output Parameters->2022 - 9 - 12 */
	@Test
	public void test_GetDateOfExpiry() {
		medicineStock.setDateOfExpiry(new java.util.Date(2022 - 9 - 12));
		assertEquals(new java.util.Date(2022 - 9 - 12), medicineStock.getDateOfExpiry());

	}
	/* This method tests for setter NumberOfTabletsInStock attribute
	 * Input Parameters->100, Output Parameters->100 */
	@Test
	public void test_SetNumberOfTabletsInStock() {
		medicineStock.setNumberOfTabletsInStock(100);
		assertEquals(100,medicineStock.getNumberOfTabletsInStock());
	}
	/* This method tests for getter NumberOfTabletsInStock attribute 
	 * Input Parameters->100, Output Parameters->100*/
	@Test
	public void test_GetNumberOfTabletsInStock() {
		medicineStock.setNumberOfTabletsInStock(100);
		assertEquals(100, medicineStock.getNumberOfTabletsInStock());

	}
	
	
	
	
	

}