package com.PharmacySupply.UserPortal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:9001/pharmacy/medicine-stock", name = "medicine-stock-service")
public interface MedicineStockFeign {

	@PostMapping("/byTreatingAilment/{treatingAilment}")
	public String[] getMedicineByTreatingAilment(@RequestHeader("Authorization") String token,
			@PathVariable("treatingAilment") String treatingAilment);

	@GetMapping("/MedicineStockInformation")
	public ResponseEntity<?> getMedicineStockInformation(@RequestHeader(name = "Authorization") String token);
}