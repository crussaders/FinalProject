package com.cognizant.medRepSchedule.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "medicine-stock-service", url = "http://localhost:9001/pharmacy/medicine-stock")
public interface MedicineStockFeignClient {

	/*
	 * This method is responsible get medicine mapped to treating ailment from
	 * medicine-stock-service. InputParameter -> String token, String
	 * treatingAilment. Output -> get a array of medicines.
	 **/
	@PostMapping("/byTreatingAilment/{treatingAilment}")
	public String[] getMedicinesByTreatingAilment(@RequestHeader("Authorization") String token,
			@PathVariable("treatingAilment") String treatingAilment);

}
