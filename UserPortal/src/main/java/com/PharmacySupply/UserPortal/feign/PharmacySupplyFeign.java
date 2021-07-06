package com.PharmacySupply.UserPortal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PharmacySupply.UserPortal.model.MedicineDemand;

@FeignClient(url = "http://localhost:9003/pharmacy/medical-supply", name = "pharmacy-medicine-supply")
public interface PharmacySupplyFeign {


	@RequestMapping("/pharmacy-supply")
	public ResponseEntity<?> getPharmacySupply(@RequestHeader(name = "Authorization") String token,
			@RequestBody List<MedicineDemand> medicineDemandList);


	@RequestMapping("/getMedicineSupply")
	public ResponseEntity<?> getMedicineSupply(@RequestHeader(name = "Authorization") String token);

	@RequestMapping("/getMedicineDemand")
	public ResponseEntity<?> getMedicineDemand(@RequestHeader(name = "Authorization") String token);

}

