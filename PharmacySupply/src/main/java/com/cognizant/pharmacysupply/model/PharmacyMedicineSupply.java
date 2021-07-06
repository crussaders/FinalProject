package com.cognizant.pharmacysupply.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Medicine Supply entity class is a POJO class, as having the ability to represent
 * objects in the database Included with the Setters and Getters methods and All
 * argument constructor and no argument constructor with the respective annotations. 
 */
@Entity
@Table(name="medicine_supply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PharmacyMedicineSupply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int id;	
	private String pharmacyName;
	private String medicineName;
	private int supplyCount;


}
