package com.PharmacySupply.UserPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PharmacySupply.UserPortal.HeaderToken;
import com.PharmacySupply.UserPortal.feign.MedicineStockFeign;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StockService {
	@Autowired
	private HeaderToken authtoken;
	@Autowired
	private MedicineStockFeign stockfeign;
	
	public ResponseEntity<?> getMedicineStockInformation(String token) {
		log.info("Start");
		log.debug("token{}:", token);
		ResponseEntity<?> response = stockfeign.getMedicineStockInformation(authtoken.getTokenWithHeader(token));
		return response;
	}

}
