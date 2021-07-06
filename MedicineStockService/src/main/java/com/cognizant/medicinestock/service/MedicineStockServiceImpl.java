package com.cognizant.medicinestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicinestock.exception.MedicineNotFoundException;
import com.cognizant.medicinestock.exception.TreatingAilmentNotFoundException;
import com.cognizant.medicinestock.model.MedicineStock;
import com.cognizant.medicinestock.repository.MedicineStockRepository;

import lombok.extern.slf4j.Slf4j;

/* This is a MedicineStockServiceImpl class which implements MedicineStockService and provides the implementation for the methods
  which we declared in the MedicineStockService interface */
@Service
@Slf4j
public class MedicineStockServiceImpl implements MedicineStockService{

	
	@Autowired
	private MedicineStockRepository repository;
	
	/* This method will fetch all the medicine details present in the database
	 * Input Parameter->get all medicines by giving findAll method, Output Parameter->fetches all the medicine stored in database */
	@Override
	public List<MedicineStock> getMedicineStockInformation() {
		log.info("START");
		log.info("END");
		return repository.findAll();
		
	}
	
	/* This method will fetch the medicine details based on the target ailment specified
	 * Input Parameter-> treatingAilment, Output Parameter->get the medicine values based on treating ailment */
	@Override
	public List<MedicineStock> getMedicineByTargetAilment(String treatingAilment) throws TreatingAilmentNotFoundException {
		log.info("START");
		log.info("END");
		List<MedicineStock> medicinestock=null;
		  medicinestock=repository.getMedicineByTargetAilment(treatingAilment);
		if(medicinestock==null || medicinestock.isEmpty()){
			throw new TreatingAilmentNotFoundException("Treating Ailment Not Found");
		}
		return medicinestock;
		
	}
	
	/* This method will give the tablets in stock with the help of medicine name 
	 * Input Parameter->medicine name, Output Parameter->gives the count of medicine*/
	@Override
	public MedicineStock getNumberOfTabletsInStockByName(String medicine) throws MedicineNotFoundException  {
		log.info("START");
		log.info("END");
		MedicineStock numberOfTabletsInStockByName=null;
		 numberOfTabletsInStockByName = repository.getNumberOfTabletsInStockByName(medicine);
		log.debug("NUMBER OF TABLETS IN STOCK BY NAME {}:", numberOfTabletsInStockByName);
		if(numberOfTabletsInStockByName==null ){
			throw new MedicineNotFoundException ("Medicine Not Found");
		}
		return numberOfTabletsInStockByName;
		}

	/* This method will update the tablets count based on the  name specified
	 * Input Parameter ->medicine,count ,Output Parameter->update the count value */
	
	@Override
	public Boolean updateNumberOfTabletsInStockByName(String medicine, int count) {
		log.info("START");
		log.info(medicine + "------------" + count);
		repository.updateNumberOfTabletsInStockByName(medicine, count);
		log.info("END");
		return true;
	}

}
