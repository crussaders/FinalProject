package com.PharmacySupply.AuthenticationService.Exception;

/*********************************************************
 * UserNotFoundException is CustomException class which will handle by
 * GlobalErrorHandler class this exception occur when User
 * is not present in database
 *********************************************************/
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public UserNotFoundException(String message)
	{
		super(message);
	}
}
