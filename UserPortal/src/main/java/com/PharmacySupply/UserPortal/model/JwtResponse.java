package com.PharmacySupply.UserPortal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class JwtResponse {

	private String userid;
	private String username;
	private boolean isValid;
}
