package com.cognizant.medicinestock.model;

/* This is a  JwtResponse POJO Class with  attributes like userid and valid */
import java.util.Date;

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
public class JwtResponse {
	
	private String userid;

	private boolean valid;

}
