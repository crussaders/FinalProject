package com.cognizant.pharmacysupply.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Medicine Demand entity class is a POJO class, as having the ability to represent
 * objects in the database Included with the Setters and Getters methods and All
 * argument constructor and no argument constructor with the respective annotations. 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="medicine_demand")
public class MedicineDemand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message = "Medicine must not be empty")
	@NotNull(message = "Medicine must not be null")
	private String medicineName;
	
	@NotNull(message = "Medicine count cannot not be null")
	@Min(value = 1, message = "Medicine should be greater than zero")
	private int demandCount;


	
	
}
