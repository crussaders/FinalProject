package com.PharmacySupply.AuthenticationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
/*******************************************************
 * UserLoginCredentials class is use as AuthRequest which 
 * is used by Login() method of AuthController
********************************************************/
public class UserLoginCredentials {
	private String userid;
	private String password;
}
