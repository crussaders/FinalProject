package com.PharmacySupply.UserPortal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PharmacySupply.UserPortal.Exception.MedicineNotFoundException;
import com.PharmacySupply.UserPortal.model.MedicineDemand;
import com.PharmacySupply.UserPortal.model.MedicineSupply;
import com.PharmacySupply.UserPortal.service.AuthenticationService;
import com.PharmacySupply.UserPortal.service.SupplyServcie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pharmacy")
public class SupplyController {

	@Autowired
	private SupplyServcie feignservice;
	@Autowired
	private AuthenticationService authfeign;
	@RequestMapping("/getMedicineSupply")
	public ModelAndView getMedicineSupply(@ModelAttribute("medicineDemand") MedicineDemand medicineDemand,
			HttpSession session) throws Exception {

		log.info("Start");

		ModelAndView modelAndView = new ModelAndView();
		String token = (String) session.getAttribute("token");
		List<MedicineDemand> medicineDemandList = new ArrayList<>();
		medicineDemandList.add(medicineDemand);
		log.debug("medicineDemand{} :", medicineDemand);
		if(medicineDemand.getDemandCount()<=0) {
			modelAndView.addObject("errorMessage", true);
			modelAndView.setViewName("medicineDemand");
			return modelAndView;
		}
		ResponseEntity<?> response = feignservice.getPharmacySupply(token, medicineDemandList);
		HttpStatus statusCode = response.getStatusCode();
		if (statusCode == HttpStatus.NOT_FOUND) {
			modelAndView.addObject("error", true);
		}
		if (response.getBody() instanceof String) {
			throw new MedicineNotFoundException("Medicine not found");
		}
		log.debug("response atik{}:", response);
		List<MedicineSupply> medicineSupplyList = (List<MedicineSupply>) response.getBody();
		log.debug("medicineSupplyList{}:", medicineSupplyList);
		modelAndView.setViewName("medicineSupplyList");
		modelAndView.addObject("medicineSupplyList", medicineSupplyList);
		return modelAndView;
	}
	@RequestMapping("/showMedicineSupply")
	public ModelAndView showMedicineSupply(HttpSession session) {
		String token = (String) session.getAttribute("token");
		@SuppressWarnings("unchecked")
		List<MedicineSupply> medicineSupply = (List<MedicineSupply>) feignservice.getMedicineSupply(token).getBody();
		ModelAndView mv = new ModelAndView("medicineSupplyList");
		mv.addObject("medicineSupplyList", medicineSupply);
		return mv;
	}
	@RequestMapping("/medicineDemand")
	public ModelAndView getMedicineDemandPage(HttpSession session) {
		String token=session.getAttribute("token").toString();
		log.info("TOKEN => {}",token);
		String response="";
			if(authfeign.verifyToken(token));
			{
				response="medicineDemand";
			}
		ModelAndView modelAndView = new ModelAndView(response);
		return modelAndView;
	}
	@RequestMapping("/showMedicineDemand")
	public ModelAndView getMedicineDemandList(HttpSession session) {
		log.info("Start");
		String token = (String) session.getAttribute("token");
		@SuppressWarnings("unchecked")
		List<MedicineDemand> medicineDemandList = (List<MedicineDemand>) feignservice.getMedicineDemand(token)
				.getBody();
		ModelAndView mv = new ModelAndView("showMedicineDemand");
		mv.addObject("medicineDemandList", medicineDemandList);
		log.debug("medicineDemandList{}:", medicineDemandList);
		return mv;
	}
}
