package com.cognizant.medicinestock.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
/* This exception throws when the treating ailment specified in the url is not there in database */
public class TreatingAilmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/* Parameterized constructor for Invalid token Exception to print user defined messages.
	 * InputParameter -> String exception message.
	 * String exception message will be passed to parent Class.*/
	public TreatingAilmentNotFoundException(String message) {
		super(message);
	}

}
