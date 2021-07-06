package com.cognizant.medRepSchedule.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medRepSchedule.exception.InvalidDateException;
import com.cognizant.medRepSchedule.exception.InvalidTokenException;
import com.cognizant.medRepSchedule.feignClient.AuthenticationFeignClient;
import com.cognizant.medRepSchedule.model.Doctor;
import com.cognizant.medRepSchedule.model.JwtResponse;
import com.cognizant.medRepSchedule.model.Representative;
import com.cognizant.medRepSchedule.model.RepresentativeSchedule;
import com.cognizant.medRepSchedule.service.MedicalRepresentativeScheduleService;
import com.cognizant.medRepSchedule.service.RepresentativeService;
import com.cognizant.medRepSchedule.util.CsvReader;
import com.cognizant.medRepSchedule.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MedicalRepresentativeController {

	@Autowired
	private MedicalRepresentativeScheduleService scheduleService;

	@Autowired
	private RepresentativeService representativeService;

	@Autowired
	private AuthenticationFeignClient authFeignClient;

	/*
	 * Environment is for setting up log values
	 */
	@Autowired
	private Environment env;

	/*
	 * Get all list of doctors from CSV file Output -> list of doctors.
	 */
	@GetMapping("/doctors")
	public List<Doctor> getDoctors() {
		log.info(env.getProperty("log.start"));

		List<Doctor> doctors = CsvReader.parseDoctor();

		log.info(env.getProperty("log.end"));
		return doctors;
	}
	
	/*
	 * Fetch all medical representatives from database
	 * 
	 * @RequestHeader -> For passing authorization token. InputParameter -> String
	 * token OutputParameter -> list of medicalReprentative
	 */
	@GetMapping("/medicalRepresentatives")
	public List<Representative> getMedicalRepresentatives(@RequestHeader(name = "Authorization") final String token)
			throws InvalidTokenException {
		log.info(env.getProperty("log.start"));

		List<Representative> medicalRepresentatives = representativeService.getMedicalRepresentatives(token);
		log.debug("Size", medicalRepresentatives.size());

		log.info(env.getProperty("log.end"));
		return medicalRepresentatives;
	}

	/*
	 * Schedule meetings of representatives from the mentioned date with doctors.
	 * InputParameter -> String token, String scheduleStartDate OutputParameter ->
	 * Return Response of not null objects of RepresentativeSchedule
	 */
	@GetMapping("/RepSchedule/{scheduleStartDate}")
	public ResponseEntity<List<RepresentativeSchedule>> getRepSchedule(
			@RequestHeader(name = "Authorization") final String token,
			@PathVariable("scheduleStartDate") String scheduleStartDate)
			throws InvalidDateException, InvalidTokenException {
		log.info(env.getProperty("log.start"));

		List<RepresentativeSchedule> repSchedule = null;

		LocalDate localDate = DateUtil.getDate(scheduleStartDate);

		if (!isValidSession(token)) {
			log.info(env.getProperty("log.tokenExpired"));
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		if (localDate == null) {
			log.info(env.getProperty("log.end"));
			throw new InvalidDateException("Please Enter Valid Date");

		}

		repSchedule = scheduleService.getRepresentativesSchedule(token, localDate);

		log.debug("repSchedule : {}", repSchedule);

		if (repSchedule.isEmpty()) {
			log.info(env.getProperty("log.end"));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		log.info(env.getProperty("log.end"));
		return ResponseEntity.of(Optional.of(repSchedule));

	}

	/*
	 * Check for token passed is valid or not Input -> String token Output =>
	 * Boolean value (true) if token is valid else throw InvalidTokenException.
	 */
	public Boolean isValidSession(String token) throws InvalidTokenException {
		log.info(env.getProperty("log.start"));

		final JwtResponse response = authFeignClient.verifyToken(token);

		if (!response.isValid()) {
			log.info(env.getProperty("log.tokenExpired"));

			throw new InvalidTokenException("Invalid Token");
		}

		log.info(env.getProperty("log.end"));
		return true;
	}

}



