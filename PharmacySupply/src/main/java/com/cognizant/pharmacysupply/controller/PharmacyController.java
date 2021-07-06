package com.cognizant.pharmacysupply.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pharmacysupply.exception.MedicineNotFoundException;
import com.cognizant.pharmacysupply.exception.TokenValidationFailedException;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;
import com.cognizant.pharmacysupply.service.PharmacyServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * This Class Takes care of mapping request data to the defined request handler method
 * once response body is generated from handler method it converts it to Json or xml response. 
 */
@Slf4j
@RestController
public class PharmacyController {
	
	@Value("${token.invalid}")
	private String tokenInValid;
	
	@Autowired
	public PharmacyServiceImpl pharmacyservice;
	
	/**
	 *  Method Name --> pharmacySupply
	 *  @param      --> Medicine Demand 
	 *  @return     --> Pharmacy Supply
	 *  This method takes medicine demand as input checks if there is enough stock to 
	 *  fulfill the demand, if sufficient stock is available then it supplies the medicine
	 *  else it will not supply
	 */
	
	@PostMapping("/pharmacy-supply")
	public ResponseEntity<List<PharmacyMedicineSupply>> getPharmacySupply(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody List<MedicineDemand> medicineDemandList) throws MedicineNotFoundException {
		log.info("START");
		List<PharmacyMedicineSupply> pharmacySupply = null;
		if (pharmacyservice.validateToken(token)) {
			pharmacySupply = pharmacyservice.getPharmacySupplyCount(token, medicineDemandList);	
			if (pharmacySupply == null)  {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}		
			log.info("END");
			return new ResponseEntity<>(pharmacySupply, HttpStatus.OK);
		}
		log.info("END");
		throw new TokenValidationFailedException(tokenInValid);
	}
	
	/**
	 *  Method Name --> getMedicineSupply
	 *  @param      --> Null
	 *  @return     --> Medicine Supplied
	 *  This method returns the medicine supplied till this time.
	 */

	@GetMapping("/getMedicineSupply")
	public ResponseEntity<List<PharmacyMedicineSupply>> getMedicineSupply(@RequestHeader("Authorization") String token) {
		log.info("START");
		List<PharmacyMedicineSupply> medicineSupply = null;
		if (pharmacyservice.validateToken(token)) {
			medicineSupply = pharmacyservice.getMedicineSupply();
			return new ResponseEntity<>(medicineSupply, HttpStatus.OK);
		}
		log.info("END");
		throw new TokenValidationFailedException(tokenInValid);
	}
	
	/**
	 *  Method Name --> getMedicineDemand
	 *  @param      --> Null
	 *  @return     --> Medicine Demanded
	 *  This method returns the medicine demanded till this time.
	 */
	
	@GetMapping("/getMedicineDemand")
	public ResponseEntity<List<MedicineDemand>> getMedicineDemand(@RequestHeader(name = "Authorization") String token) {
		log.info("START");
		List<MedicineDemand> medicineDemand = null;
		if (pharmacyservice.validateToken(token)) {
			medicineDemand = pharmacyservice.getMedicineDemand();
			return new ResponseEntity<>(medicineDemand, HttpStatus.OK);
		}
		log.info("END");
		throw new TokenValidationFailedException(tokenInValid);
	}
	
}
