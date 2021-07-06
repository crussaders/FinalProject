package com.PharmacySupply.UserPortal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PharmacySupply.UserPortal.model.UserLoginCredentails;
import com.PharmacySupply.UserPortal.model.UserToken;
import com.PharmacySupply.UserPortal.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/pharmacy")
public class LoginController {

//	Autowiring to AuthenticationService is done here
	
	@Autowired
	private AuthenticationService authservice;

	@GetMapping("/login")
	public ModelAndView userLogin(@ModelAttribute("usercredentials") UserLoginCredentails usercredentials,
			BindingResult bindingresult) {

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginMessage", "Login");
		return modelAndView;
	}

	@GetMapping("/home")
	public ModelAndView home(HttpSession session) throws Exception {
		String token = session.getAttribute("token").toString();
		log.info("TOKEN => {}", token);
		String response = "";
		if (authservice.verifyToken(token))
			;
		{
			response = "homepage";
		}
		ModelAndView modelAndView = new ModelAndView(response);
		return modelAndView;
	}

	@PostMapping("/homepage")
	public ModelAndView userLogin(@ModelAttribute("usercredentials") UserLoginCredentails usercredentials,
			BindingResult bindingresult, HttpSession session) {

		log.debug("username{}: ", usercredentials.getUserid());
		ResponseEntity<?> response = null;

		try {
			response = authservice.getToken(usercredentials);
		} catch (Exception e) {
			log.error("Invalid credentials");
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("loginMessage", "Bad Credentials");
			return modelAndView;
		}
		log.debug("Response{}: ", response);
		log.info("Getting body from response entity");
		UserToken userToken = (UserToken) response.getBody();
		log.debug("token{}:", userToken.getAuthToken());
		log.debug("userToken{}: ", userToken);
		session.setAttribute("token", userToken.getAuthToken());
		log.debug("session{}:", session.toString());
		ModelAndView modelAndView = new ModelAndView("homepage");
		return modelAndView;

	}

	@GetMapping("/log")
	public ModelAndView getlogout(HttpSession session) throws Exception {
		String token = session.getAttribute("token").toString();
		log.info("TOKEN => {}", token);
		String response = "";
		if (authservice.verifyToken(token))
			;
		{
			response = "logout";
		}
		ModelAndView modelAndView = new ModelAndView(response);
		return modelAndView;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("token", null);
		log.info("TOKEN => {}", session.getAttribute("token"));
		return "login";
	}

}
