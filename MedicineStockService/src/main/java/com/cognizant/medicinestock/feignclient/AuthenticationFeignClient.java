package com.cognizant.medicinestock.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.medicinestock.model.JwtResponse;


/* This Feign Client interface is used to connect authentication microservice with our microservice i.e.,medicine-stock-microservice in an application */
@FeignClient(name = "authentication-service", url ="http://localhost:9000/pharmacy/auth")
public interface AuthenticationFeignClient {

   /* This method is used to verify the generated token
    * Input parameter ->token, OutputParameter -> verifies the token  */
	
	@RequestMapping(path = "/validate",method=RequestMethod.GET)
	public JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
