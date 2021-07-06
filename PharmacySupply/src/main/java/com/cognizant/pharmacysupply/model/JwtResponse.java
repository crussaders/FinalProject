package com.cognizant.pharmacysupply.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * This is the Pojo class for Jwt Response Included with the Setters and Getters methods and All
 * argument constructor and no argument constructor with the respective annotations. 
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class JwtResponse implements Serializable{

	private static final long serialVersionUID = -8091879091924046844L;
	private String userid;
	private boolean valid;
		
	
}
