package com.cognizant.pharmacysupply.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cognizant.pharmacysupply.exception.MedicineNotFoundException;
import com.cognizant.pharmacysupply.exception.TokenValidationFailedException;
import com.cognizant.pharmacysupply.feignclient.AuthenticationFeignClient;
import com.cognizant.pharmacysupply.feignclient.MedicineStockFeignClient;
import com.cognizant.pharmacysupply.model.JwtResponse;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.MedicineStock;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;
import com.cognizant.pharmacysupply.repository.MedicineDemandRepository;
import com.cognizant.pharmacysupply.repository.PharmacyMedicineSupplyRepository;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

/**
 * The service class implements the PharmacyService interface and have the business logic of
 * updating the stock values and storing the medicine demand and medicine supply into the database.  
 */
@Slf4j
@Service
public class PharmacyServiceImpl implements PharmacyService{
	@Autowired
	private MedicineDemandRepository medicineDemandRepo;

	@Autowired
	private MedicineStockFeignClient stockFeignClient;

	@Autowired
	private PharmacyMedicineSupplyRepository pharmacyMedicineSupplyRepository;

	@Autowired
	private AuthenticationFeignClient authFeign;

	@Autowired
	private MedicineDemandRepository medicineDemandRepository;
	
	@Value("${token.invalid}")
	private String tokenInValid;
	
	@Value("${medicine.notfound}")
	private String medcineNotFound;
		
	/**
	 * Method Name --> getPharmacySupplyCount
	 * @param     --> token
	 * @param      --> medicineDemandList
	 * @return     --> List of MedicineSupply
	 * Get the count of supply from stock on giving the input as demand count. We
	 * are getting the supply count from the medicine stock service via feign
	 * client. And if the medicine demand count is higher then the medicine supply
	 * count we are setting demand count as supply count.
	 */
	@Override
	public List<PharmacyMedicineSupply> getPharmacySupplyCount(String token, List<MedicineDemand> medicineDemandList)
			throws MedicineNotFoundException {
		log.info("START");
		
		List<PharmacyMedicineSupply> pharmacySupplyList = new ArrayList<>();
	
		
		for (MedicineDemand medicineDemand : medicineDemandList) {
			
			PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();
			
			MedicineStock medicineStock = getNumberOfTablets(token, medicineDemand);
			
			if (medicineStock.getNumberOfTabletsInStock() < medicineDemand.getDemandCount()) {
				return null;
			}
			
			setSupply(token, pharmacyMedicineSupply, medicineDemand, medicineStock);
			pharmacySupplyList.add(pharmacyMedicineSupply);
		}
		pharmacyMedicineSupplyRepository.saveAll(pharmacySupplyList);
		medicineDemandRepository.saveAll(medicineDemandList);
		log.info("END");
		return pharmacySupplyList;
	}
	
	/**
	 * Method Name --> setSupply
	 * @param      --> token
	 * @param      --> medicineDemand
	 * @param      --> medicineSupply
	 * @param      --> medicineStock
	 * This Method takes the medicineDemand medicineSupply and medicineStock as input and check for the 
	 * stock availablity if the required stock is available updating the stock by subtracting the demand count.
	 */
	
	public void setSupply(String token, PharmacyMedicineSupply medicineSupply, MedicineDemand medicineDemand,
			MedicineStock medicineStock) throws MedicineNotFoundException {
		log.info("START");
		int val = 0;
		if (medicineStock.getNumberOfTabletsInStock() < medicineDemand.getDemandCount()) {
			medicineSupply.setSupplyCount(medicineStock.getNumberOfTabletsInStock());

		} else {
			medicineSupply.setSupplyCount(medicineDemand.getDemandCount());
			val = medicineStock.getNumberOfTabletsInStock() - medicineDemand.getDemandCount();

		}
		try {
			stockFeignClient.updateNumberOfTabletsInStockByName(token, medicineDemand.getMedicineName(), val);
		} catch (FeignException feignException) {
			throw new MedicineNotFoundException(medcineNotFound);
		}
		medicineSupply.setMedicineName(medicineDemand.getMedicineName());
		medicineSupply.setPharmacyName(medicineStock.getPharmacyName());
		log.info("END");
	}

	/**
	 * Method Name --> getNumberOfTablets
	 * @param      --> token
	 * @param      --> medicineDemandList
	 * @return     --> List of  MedicineSupply
	 * Get the count of supply from stock on giving the input as demand count. We
	 * are getting the supply count from the medicine stock service via feign
	 * client. And if the medicine demand count is higher then the medicine supply
	 * count we are setting demand count as supply count.
	 */
	
	public MedicineStock getNumberOfTablets(String token, MedicineDemand medicineDemand)
			throws MedicineNotFoundException {
		log.info("START");
		MedicineStock medicineStock = null;
		try {
			medicineStock = stockFeignClient.getNumberOfTabletsInStockByName(token, medicineDemand.getMedicineName());
		} catch (FeignException feignException) {
			throw new MedicineNotFoundException(medcineNotFound);
		}

		if (medicineStock == null ) {
			throw new MedicineNotFoundException(medcineNotFound);
		}
		log.info("END");
		return medicineStock;
	}
	/**
	 * Method Name --> getMedicineDemand 
	 *  @return     --> List of medicine demand
	 * From the database we are fetching all the {@link MedicineDemand}. We are
	 * invoking method findAll() which is present in the {@link JpaRepository}
	 * interface.
	 */
	
	@Override
	public List<MedicineDemand> getMedicineDemand() {
		log.info("START");
		return medicineDemandRepo.findAll();
	}
	
	/**
	 * Method Name --> getMedicineSupply
	 * @return     --> List of medicine supply
	 * From the database we are fetching all the {@link MedicineSupply}. We are
	 * invoking method findAll() which is present in the {@link JpaRepository}
	 * interface. 
	 */
	 @Override
		public List<PharmacyMedicineSupply> getMedicineSupply() {
		 log.info("START");
			return pharmacyMedicineSupplyRepository.findAll();
		}


	 /**
	  * Method Name --> validateToken 
	  * @return     --> Boolean Value
	  * Validate the token received inside the Authorization part of the header
	  */
	@Override
	public Boolean validateToken(String token) {
		log.info("START");

		JwtResponse jwtResponse = authFeign.verifyToken(token);
		
		log.info("END");

		if (jwtResponse.isValid())
			return true;
		throw new TokenValidationFailedException(tokenInValid);

	}
}
