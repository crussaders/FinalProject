package com.cognizant.medRepSchedule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

/*
 * This Class is responsible for getting all the details of doctor from csv
 * file. 
 */
public class Doctor {

	private int id;
	private String name;
	private String contactNumber;
	private String treatingAilment;

}
