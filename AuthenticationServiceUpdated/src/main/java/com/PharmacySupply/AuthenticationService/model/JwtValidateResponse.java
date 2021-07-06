package com.PharmacySupply.AuthenticationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
/*******************************************************
 * JwtValidateResponse class is use to sent the JwtResponse
 * when JwtToken valid it is use by getValidity() method of 
 * AuthController
********************************************************/
public class JwtValidateResponse {

	private String userid;
	private boolean valid;
}
