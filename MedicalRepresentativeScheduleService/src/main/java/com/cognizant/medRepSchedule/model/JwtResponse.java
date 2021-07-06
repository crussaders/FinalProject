package com.cognizant.medRepSchedule.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

/*
 * This class is responsible for to put all the details from authentication
 * service microservice.
 */
 
public class JwtResponse {

	private String userid;
	private boolean valid;

}
