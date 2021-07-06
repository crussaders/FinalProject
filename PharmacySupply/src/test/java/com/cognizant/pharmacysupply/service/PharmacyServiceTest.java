package com.cognizant.pharmacysupply.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.pharmacysupply.exception.MedicineNotFoundException;
import com.cognizant.pharmacysupply.exception.TokenValidationFailedException;
import com.cognizant.pharmacysupply.feignclient.AuthenticationFeignClient;
import com.cognizant.pharmacysupply.feignclient.MedicineStockFeignClient;
import com.cognizant.pharmacysupply.model.JwtResponse;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.MedicineStock;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;

import lombok.extern.slf4j.Slf4j;

/**
 * This Class checks the methods of the PharmacyServiceImplementation methods.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacyServiceTest {
	
	@Autowired
	private PharmacyServiceImpl medicineSupplyServiceImpl;

	@Mock
	private MedicineDemand medicineDemand;

	@Mock
	private PharmacyMedicineSupply medicineSupply;

	@Mock
	private MedicineStock medicineStock;

	@MockBean
	private AuthenticationFeignClient authFeignClient;
	
	@Mock
	private MedicineStockFeignClient medicineStockFeignClient;

	List<MedicineDemand> medicineDemandList = new ArrayList<>();
	

	/**
	 * Method Name --> setup
	 * Before running test cases this method should run to set the value for fields.
	 */
	@Before
	public void setup() {
		medicineDemand = new MedicineDemand(1, "Crocin", 100);
		medicineDemandList.add(medicineDemand);
		medicineSupply = new PharmacyMedicineSupply(1, "Healthy Pharmacy", "Crocin", 200);
		medicineStock = new MedicineStock(1, "Crocin", "digoxin", "General", "Healthy Pharmacy",
				new java.util.Date(2022 - 9 - 12), 500);
	}
	/**
	 * Method Name --> testGetMedicineSupply
	 * This method checks the GetMedicineSupply method in service class which gives the medicine 
	 * supply object should not be null.
	 */
	@Test
	public void testGetMedicineSupply() {
		log.info("Start");
		List<PharmacyMedicineSupply> medicineSupply = medicineSupplyServiceImpl.getMedicineSupply();
		assertNotNull(medicineSupply);
		log.info("End");
	}
	/**
	 * Method Name --> testGetPharmacySupply
	 * @throws MedicineNotFoundException
	 * This method checks for the GetPharmacySupply method in service class which gives the 
	 * medicine supply object should not be null. 
	 */
	@Test(expected = MedicineNotFoundException.class)
	public void testGetPharmacySupply() throws MedicineNotFoundException {
		log.info("Start");

		List<PharmacyMedicineSupply> medicineSupply = null;
		when(medicineSupplyServiceImpl.getNumberOfTablets("token", medicineDemand)).thenReturn(medicineStock);
		medicineSupply = medicineSupplyServiceImpl.getPharmacySupplyCount("token", medicineDemandList);
		assertNotNull(medicineSupply);
		log.info("End");
	}

	/**
	 * Method Name --> testGetNumberOfTablets
	 * @throws MedicineNotFoundException
	 * This method checks for the GetNumberOfTablets method in service class which gives the 
	 * medicine stock object should not be null.
	 */
	@Test(expected = MedicineNotFoundException.class)
	public void testGetNumberOfTablets() throws MedicineNotFoundException {
		log.info("Start");
		MedicineStock medicineStock = null;
		when(medicineStockFeignClient.getNumberOfTabletsInStockByName("token", medicineDemand.getMedicineName()))
				.thenReturn(medicineStock);
		medicineStock = medicineSupplyServiceImpl.getNumberOfTablets("token", medicineDemand);
		assertNotNull(medicineStock);
		log.info("End");
	}
	/**
	 * Method Name --> testGetMedicineDemand
	 * This method checks for the GetMedicineDemand method in service class which gives the
	 * medicine Demand List which should not be null.
	 */
	@Test
	public void testGetMedicineDemand() {
		log.info("Start");
		List<MedicineDemand> medicineDemandList = null;
		medicineDemandList = medicineSupplyServiceImpl.getMedicineDemand();
		assertNotNull(medicineDemandList);
		log.info("End");
	}
	/**
	 * Method Name --> testValidateTokenSuccessful
	 * This method testValidateTokenSuccessful checks for successful by passing the token.
	 */
	@Test
	public void testValidateTokenSuccessful() {
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("root", true));
		assertTrue(medicineSupplyServiceImpl.validateToken("token"));
	}
	
	/**
	 * Method Name --> testValidateTokenFail
	 * @throws TokenValidationFailedException
	 * This method testValidateTokenFail checks for failure of the token validation by
	 * passing the wrong validation.
	 */
	@Test(expected = TokenValidationFailedException.class)
	public void testValidateTokenFail() throws TokenValidationFailedException  {
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("root", false));
		medicineSupplyServiceImpl.validateToken("token");
	}
	
	
}