package com.cognizant.medicinestock.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor

/* This class extends Run time Exception and print the message  when the medicine specified in the url is not there in the database */
public class MedicineNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/* Parameterized constructor for Invalid token Exception to print user defined messages.
	 * InputParameter -> String exception message.
	 * String exception message will be passed to parent Class.*/
	public MedicineNotFoundException(String message) {
		super(message);
	}

}
