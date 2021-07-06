package com.cognizant.pharmacysupply.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.pharmacysupply.model.JwtResponse;

/**
 * This Feign Client is used to connect to authorization-service for authorizing our Microservice.
 */
@FeignClient(name = "authorization-service", url = "${feign.auth.url}")
public interface AuthenticationFeignClient {
	
	/**
	 * Method Name --> verifyToken
	 * @param      --> Token  (given as an input to check if the session is valid or not with the help of Token )
	 */
	
	@RequestMapping(value = "validate" ,method = RequestMethod.GET)
	public JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);
	
}
