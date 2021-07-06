package com.cognizant.medRepSchedule.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.medRepSchedule.model.JwtResponse;

@FeignClient(name = "authentication-service", url = "http://localhost:9000/pharmacy/auth")
public interface AuthenticationFeignClient {

	/*
	 * This method is responsible for varify the token that we are getting from
	 * header from authentication-service. InputParameter -> String token. Output ->
	 * JwtResponse stating valid as true.
	 **/
	@GetMapping(value = "/validate")
	public JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
