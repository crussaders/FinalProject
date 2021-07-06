package com.cognizant.pharmacysupply.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pharmacysupply.model.MedicineStock;

/**
 * This Feign Client is used to connect to medicine-stock-service for accessing the stock values.
 */

@FeignClient(url = "${feign.stock.url}", name = "medicine-stock-service")
public interface MedicineStockFeignClient {
	
	/**
	 * Method Name --> getNumberOfTabletsInStockByName
	 * @param      --> medicine name
	 * @return     --> supply count 
	 * This method takes the medicine name as input and return the Medicine Stock object as output based on the medicine name.
	*/
	@PostMapping("/pharmacy/medicine-stock/get-stock-count/{medicine}")
	public MedicineStock getNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String token,@PathVariable("medicine") String medicine);
	
	/**
	 * Method Name --> updateNumberOfTabletsInStockByName
	 * @param      --> medicine 
	 * @param      --> count
	 * @return     --> boolean value to show successful or unsuccessful update of the stock value. 
	*/
	@PostMapping("/pharmacy/medicine-stock/update-stock/{medicine}/{count}")
	public Boolean updateNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String token,@PathVariable("medicine") String medicine, @PathVariable("count") int count);	
}
