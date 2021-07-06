package com.PharmacySupply.AuthenticationService.Exception;

/*********************************************************
 * LoginFaileException is CustomException class which will handle by
 * GlobalErrorHandler class this exception occur when Login 
 * Credentials are wrong  
 *********************************************************/
public class LoginFailedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public LoginFailedException(String message)
	{
		super(message);
	}

}
