package com.PharmacySupply.AuthenticationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/*******************************************************
 * UserToken class is use as AuthResponse which 
 * is send by Login() method of AuthController if AuthRequest
 * is valid and token is generated
********************************************************/
public class UserToken {
	private String userId;
	private String authToken;
}
