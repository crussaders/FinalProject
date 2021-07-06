package com.PharmacySupply.UserPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.PharmacySupply.UserPortal.HeaderToken;
import com.PharmacySupply.UserPortal.feign.PharmacySupplyFeign;
import com.PharmacySupply.UserPortal.model.MedicineDemand;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SupplyServcie {
	@Autowired
	private HeaderToken authtoken;
	@Autowired
	private PharmacySupplyFeign supplyfeign;
	
	public ResponseEntity<?> getPharmacySupply(String token, List<MedicineDemand> medicineDemand) {
		log.info("Start");
		log.debug("medicineDemand{}:", medicineDemand);
		log.debug("token{}:", token);
		ModelAndView modelAndView = new ModelAndView();
		ResponseEntity<?> response = null;
		try {
			response = supplyfeign.getPharmacySupply(authtoken.getTokenWithHeader(token), medicineDemand);
			log.debug("response{}:", response);
		} catch (FeignException e) {
			modelAndView.setViewName("medicineNotFound");
			return new ResponseEntity<>("medicineNotFound", HttpStatus.NOT_FOUND);
		}
		return response;
	}
	public ResponseEntity<?> getMedicineSupply(String token) {
		log.debug("token{}:", token);
		ResponseEntity<?> response = null;
		response = supplyfeign.getMedicineSupply(authtoken.getTokenWithHeader(token));
		log.debug("response{}:", response);
		return response;
	}
	public ResponseEntity<?> getMedicineDemand(String token) {
		log.debug("token{}:", token);
		ResponseEntity<?> response = null;
		response = supplyfeign.getMedicineDemand(authtoken.getTokenWithHeader(token));
		log.debug("response{}:", response);
		return response;
	}

}
