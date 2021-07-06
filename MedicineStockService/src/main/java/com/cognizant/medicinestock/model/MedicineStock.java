package com.cognizant.medicinestock.model;

/* This is a MedicineStock  POJO Class with  attributes like id,name,chemicalComposition,targetAilment ,
  dateOfExpiry, numberOfTabletsInStock, and pharmacyName */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "medicine_stock")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class MedicineStock {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String chemicalComposition;
	private String targetAilment;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfExpiry;
	private int numberOfTabletsInStock;
	private String pharmacyName;

	



}
