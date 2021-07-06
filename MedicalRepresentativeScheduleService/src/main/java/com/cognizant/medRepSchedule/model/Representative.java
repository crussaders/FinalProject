package com.cognizant.medRepSchedule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "medical_representatives")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString

/*
 * This class behaves an entity for database. create an table
 * medical_representatives in database by using all field name as attributes of
 * table.
 */
public class Representative {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;

}
 