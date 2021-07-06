package com.cognizant.medicinestock.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medicinestock.feignclient.AuthenticationFeignClient;
import com.cognizant.medicinestock.model.JwtResponse;
import com.cognizant.medicinestock.model.MedicineStock;
import com.cognizant.medicinestock.service.MedicineStockServiceImpl;

import lombok.extern.slf4j.Slf4j;

/* This  MedicineStockControllerTest class will use mockito and junit and test the methods what we mentioned in main controller class */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class MedicineStockControllerTest {

	@Mock
	private AuthenticationFeignClient authFeignClient;

	@InjectMocks
	private MedicineStockController medicineStockController;

	@Mock
	private MedicineStock medicineStock;

	@Mock
	private List<MedicineStock> medicineStockList;

	@Mock
	private MedicineStockServiceImpl medicineStockService;
	


   /* This setup method will run before testing the methods */
	@Before
	public void setup() {
		log.info("START");
		medicineStock = new MedicineStock();
		medicineStock.setId(1);
		medicineStock.setPharmacyName("Remdesivir");
		medicineStock.setChemicalComposition("Mycolipenic acid(C27),(H35),(N6),(O8),(P)");
		medicineStock.setTargetAilment("COVID-19");
		medicineStock.setPharmacyName("Generation Pharmacy");
		medicineStock.setDateOfExpiry(new java.util.Date(2023-9-03));
		medicineStock.setNumberOfTabletsInStock(300);
		log.info("END");
	}

    /* This testGetMedicineStockInformation method will check whether the data which we mentioned in the database
     * are fetching or not, if the data fetched is correct then it will print status code OK and we use 
     * assertions  to check
     * Input parameter->token, and status Ok, Output Parameter-> status Ok */
     
	@Test
	public void testGetMedicineStockInformation() throws Exception {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", true));
		ResponseEntity<?> medicineStockInformation = medicineStockController.getMedicineStockInformation("token");
		HttpStatus statusCode = medicineStockInformation.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK, statusCode);
		log.info("End");
	}

   /* This testGetMedicineStockInformationWhenTokenNotValid methods checks when the token is not valid then it throws the exception and return those exception messages
    * Input parameter->wrong token ,Output Parameter->returns not null values that is exception messages */
	@Test
	public void testGetMedicineStockInformationWhenTokenNotValid() throws Exception {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin",false));
		ResponseEntity<?> allMedicineStockInformation = medicineStockController.getMedicineStockInformation("token");
		assertNotNull(allMedicineStockInformation);
		log.info("End");
	}

   /*  This testGetStockCountForMedicineWhenTokenValidationFails checks when the token is not valid and we are giving input as Remdesivir and sending the token then it will return  those exception messages
    * Input Parameter->token,medicine name, Output Parameter->should get exception messages */
	@Test
	public void testGetStockCountForMedicineWhenTokenValidationFails() {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin",false));
		ResponseEntity<?> stockCountForMedicine = medicineStockController.getStockCountForMedicine("token", "Remdesivir");
		assertNotNull(stockCountForMedicine);
		log.info("End");

	}
 /* this testGetStockCountForMedicine methods should return the count of Remdesivir and if the status code is OK then this test is passed
  *  Input Parameter->token,medicine name, Output Parameter->gives the count of medicine */
	@Test
	public void testGetStockCountForMedicine() {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", true));
		ResponseEntity<?> stockCountForMedicine = medicineStockController.getStockCountForMedicine("token", "Remdesivir");
		HttpStatus statusCode = stockCountForMedicine.getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
		log.info("End");
	}

/* This getMedicineByTreatingAilment method should return the medicine name based on the treating ailment and here we are giving it as COVID-19 and if it return Remdesivir
   then it will print OK status which passes the test 
	 Input Parameter->token,treatingAilment, Output Parameter->returns medicine based on treatingAilment */
	@Test
	public void getMedicineByTreatingAilment() {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", true));
		ResponseEntity<?> medicineByTreatingAilment = medicineStockController.getMedicineByTreatingAilment("token",
				"COVID-19");
		HttpStatus statusCode = medicineByTreatingAilment.getStatusCode();
		assertNotNull(statusCode);
		log.info("End");
	}
 /* This getMedicineByTreatingAilmentWhenTokenValidationFails method returns the error response message when the token is failed, we are passing COVID_19 as traeting ailment
  *  Input Parameter->wrong token,medicine name, Output Parameter->should get exception messages */
	@Test
	public void getMedicineByTreatingAilmentWhenTokenValidationFails() {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", false));
		ResponseEntity<?> medicineByTreatingAilment = medicineStockController.getMedicineByTreatingAilment("token",
				"COVID-19");
		assertNotNull(medicineByTreatingAilment);
		log.info("End");
	}

}