package com.PharmacySupply.UserPortal.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PharmacySupply.UserPortal.model.RepresentativeSchedule;
import com.PharmacySupply.UserPortal.service.AuthenticationService;
import com.PharmacySupply.UserPortal.service.RepresentativeService;
import com.PharmacySupply.UserPortal.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pharmacy")
public class RepresentativeController {

	@Autowired
	private AuthenticationService authservice;
	@Autowired
	private RepresentativeService repservice;
	@RequestMapping("/schedule")
	public ModelAndView getRepSchedule(HttpSession session) {
		String token=session.getAttribute("token").toString();
		log.info("TOKEN => {}",token);
		String response="";
			if(authservice.verifyToken(token));
			{
				response="giveRepScheduleDate";
			}
		ModelAndView modelAndView = new ModelAndView(response);
		return modelAndView;
	}
	@RequestMapping("/createSchedule")
	public ModelAndView createSchedule(@RequestParam("scheduleStartDate") String scheduleStartDate, HttpSession session)
			throws Exception {
		log.debug("dateOfMeeting {}:", scheduleStartDate);
		ModelAndView modelAndView = new ModelAndView();

		LocalDate date = DateUtil.convertToDate(scheduleStartDate);
		if (date.isBefore(LocalDate.now())) {
			modelAndView.addObject("errorMessage", true);
			modelAndView.setViewName("giveRepScheduleDate");
			return modelAndView;
		}
		String token = (String) session.getAttribute("token");
		log.debug("token {}:", token);
		ResponseEntity<?> response = repservice.getRepSchedule(token, scheduleStartDate);
		log.debug("response {}:", response);
		@SuppressWarnings("unchecked")
		List<RepresentativeSchedule> repScheduleList = (List<RepresentativeSchedule>) response.getBody();
		log.debug("medicineStock {}:", repScheduleList);
		modelAndView.setViewName("repScheduleList");
		modelAndView.addObject("repScheduleList", repScheduleList);
		return modelAndView;
	}
	
}
