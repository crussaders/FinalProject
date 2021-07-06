package com.cognizant.medRepSchedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cognizant.medRepSchedule.dao.MedicalRepresntativeRepository;
import com.cognizant.medRepSchedule.exception.InvalidTokenException;
import com.cognizant.medRepSchedule.feignClient.AuthenticationFeignClient;
import com.cognizant.medRepSchedule.model.JwtResponse;
import com.cognizant.medRepSchedule.model.Representative;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RepresentativeServiceImpl implements RepresentativeService {

	@Autowired
	private MedicalRepresntativeRepository medicalRepresentativesRepository;

	@Autowired
	private AuthenticationFeignClient authFeignClient;

	/*
	 * Environment is for setting up log values
	 */
	@Autowired
	private Environment env;

	/*
	 * This method will map all the details stored for representative in database to
	 * list of Representative. InputParameter -> String token. Output -> List of
	 * Representative.
	 */

	@Override
	public List<Representative> getMedicalRepresentatives(String token) throws InvalidTokenException {
		log.info(env.getProperty("log.start"));

		if (!isValidSession(token)) {
			log.info(env.getProperty("log.tokenExpired"));
			return null;
		}

		log.info(env.getProperty("log.end"));

		return medicalRepresentativesRepository.findAll();
	}

	/*
	 * This method is responsible for validating the token. It will match the input
	 * string with the header token from authentication-service. InputParameter ->
	 * String token. Output -> Return boolean (true) if token is valid. Else throw
	 * InvalidTokenException
	 */
 
	public Boolean isValidSession(String token) throws InvalidTokenException {

		log.info(env.getProperty("log.start"));

		JwtResponse response = authFeignClient.verifyToken(token);

		log.debug("response : {}", response);

		if (!response.isValid()) {
			log.info(env.getProperty("log.tokenExpired"));
			throw new InvalidTokenException("Invalid Token");
		}

		log.info(env.getProperty("log.end"));

		return true;
	}

}
