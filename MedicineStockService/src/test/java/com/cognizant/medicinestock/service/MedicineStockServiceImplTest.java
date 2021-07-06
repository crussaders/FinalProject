package com.cognizant.medicinestock.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.cognizant.medicinestock.model.MedicineStock;

import lombok.extern.slf4j.Slf4j;
/* This MedicineStockService will use mockito and junit and test the methods what we mentioned in main service package */ 

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc

public class MedicineStockServiceImplTest {

	@Autowired
	private MedicineStockServiceImpl medicineStockService;

	@Mock
	private MedicineStock medicineStock;
/* In this  testGetMedicineStockInformation method ,it will check whether all the medicine details  are obtained correct or not
 * Input Parameters->medicineList, Output Parameters->medicineList */
 
	@Test
	public void testGetMedicineStockInformation() {
		log.info("Start");
		List<MedicineStock> medicineList = medicineStockService.getMedicineStockInformation();
		assertNotNull(medicineList);
		log.info("End");
	}
/* In this testGetMedicineStockInformationFail method ,it will check all the medicine details obtained true or not
 * Input Parameters->medicineList,Output Parameters->medicineList */
	@Test
	public void testGetMedicineStockInformationFail() {
		log.info("Start");
		List<MedicineStock> medicineList = medicineStockService.getMedicineStockInformation();
		assertNotNull(medicineList);
		log.info("End");
	}
/* In this testGetStockCountForMedicineFail method , it will print the stock count for treating ailment  covid-19
 * Input Parameters->COVID-19, Output Parameters->stock count */ 
	@Test
	public void testGetStockCountForMedicineFail() {
		log.info("Start");
		List<MedicineStock> numberOfTabletsInStockByName = medicineStockService
				.getMedicineByTargetAilment("COVID-19");
		assertNotNull(numberOfTabletsInStockByName);
		log.info("End");
	}
/* In this testGetNumberOfTabletsInStockByName method , it will get the count for the medicine based on the name
 * Input Parameters->medicine name, Output Parameters->stock count */
	@Test
	public void testGetNumberOfTabletsInStockByName() {
		log.info("Start");
		MedicineStock numberOfTabletsInStockByName = medicineStockService.getNumberOfTabletsInStockByName("Remdesivir");
		assertNotNull(numberOfTabletsInStockByName);
		log.info("End");
	}
}