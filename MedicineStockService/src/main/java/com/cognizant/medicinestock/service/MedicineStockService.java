package com.cognizant.medicinestock.service;

import java.util.List;

import com.cognizant.medicinestock.model.MedicineStock;

/* This is a MedicineStockService interface and here we  declared the definition of methods */
public interface MedicineStockService {

	
	
	public List<MedicineStock> getMedicineStockInformation();
	public List<MedicineStock> getMedicineByTargetAilment(String treatingAilment);
	public MedicineStock getNumberOfTabletsInStockByName(String medicine);
	public Boolean updateNumberOfTabletsInStockByName(String medicine, int count);
}
