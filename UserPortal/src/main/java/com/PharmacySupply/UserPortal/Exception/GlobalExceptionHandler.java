package com.PharmacySupply.UserPortal.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllErrors(Exception ex) {
		log.info("Start");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginMessage", "First Login !!");
		return modelAndView;
	}

	@ExceptionHandler(MedicineNotFoundException.class)
	public ModelAndView handleAllMedicineStockErrors(MedicineNotFoundException ex) {
		log.info("Start");
		ModelAndView modelAndView = new ModelAndView("medicineNotFound");
		return modelAndView;
	}
}
