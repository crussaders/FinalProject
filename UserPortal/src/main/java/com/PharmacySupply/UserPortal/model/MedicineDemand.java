package com.PharmacySupply.UserPortal.model;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class MedicineDemand {
	@JsonIgnore
	private int id;
	@NotEmpty(message = "Medicine field must not be empty")
	@NotNull(message = "Medicine field must not be null")
	private String medicineName;
	private int demandCount;
}
