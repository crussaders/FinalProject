package com.cognizant.pharmacysupply.exception;

import lombok.NoArgsConstructor;

/**
 * This class handles the custom MedicineNotFound Exception.
 */
@NoArgsConstructor
public class MedicineNotFoundException extends Exception{
	

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Method Name --> MedicineNotFoundException
	 *  @param      --> Message 
	 *  This method takes thrown message ,By the help of custom exception you can have your own exception and message.
	 */
	public MedicineNotFoundException(String message) {
		super(message);
	}
}
