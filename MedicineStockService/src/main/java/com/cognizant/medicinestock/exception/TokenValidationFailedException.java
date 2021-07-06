package com.cognizant.medicinestock.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor

/* This exception throws when the token is not valid */
public class TokenValidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/* Parameterized constructor for Invalid token Exception to print user defined messages.
	 * InputParameter -> String exception message.
	 * String exception message will be passed to parent Class.*/
	public TokenValidationFailedException(String message) {
		super(message);
	}

}
