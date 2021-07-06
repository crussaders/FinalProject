package com.cognizant.pharmacysupply.exception;

import lombok.NoArgsConstructor;

/**
 * This class handles the custom TokenValidationFailedException.
 */

@NoArgsConstructor
public class TokenValidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Method Name --> TokenValidationFailedException
	 *  @param      --> Message 
	 *  This method takes thrown message , By the help of custom exception you can have your own exception and message.
	 */
	public TokenValidationFailedException(String message) {
		super(message);
	}

}
