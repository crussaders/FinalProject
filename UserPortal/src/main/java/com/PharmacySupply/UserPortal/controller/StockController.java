package com.PharmacySupply.UserPortal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PharmacySupply.UserPortal.model.MedicineStock;
import com.PharmacySupply.UserPortal.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pharmacy")
public class StockController {

	@Autowired
	private StockService feignservice;
	@RequestMapping("/medicineStock")
	public ModelAndView getMedicineStockDetails(HttpSession session) throws Exception {
		log.info("Start---------inside getMedicineStockDetails");
		String token = (String) session.getAttribute("token");
		log.info("Calling StockFeignClient");
		ResponseEntity<?> response = feignservice.getMedicineStockInformation(token);
		log.debug("response{}:", response);
		@SuppressWarnings("unchecked")
		List<MedicineStock> medicineStockList = (List<MedicineStock>) response.getBody();
		log.debug("medicineStock{}:", medicineStockList);
		ModelAndView modelAndView = new ModelAndView("medicineStockList");
		modelAndView.addObject("medicineStockList", medicineStockList);
		return modelAndView;
	}
}
