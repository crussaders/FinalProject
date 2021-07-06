package com.PharmacySupply.UserPortal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.PharmacySupply.UserPortal.model.JwtResponse;
import com.PharmacySupply.UserPortal.model.UserLoginCredentails;
import com.PharmacySupply.UserPortal.model.UserToken;

@FeignClient(url = "http://localhost:9000/pharmacy/auth", name = "authorization-service")
public interface AuthenticationFeign {

	@PostMapping(path = "/login")
	public ResponseEntity<UserToken> login(@RequestBody UserLoginCredentails usercredentials);

	@GetMapping(path = "/validate")
	public JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}

