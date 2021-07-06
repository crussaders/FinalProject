package com.PharmacySupply.AuthenticationService.Exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.PharmacySupply.AuthenticationService.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

/***********************************************************************
 * GlobalErrorHandler will handle all the Exception in this MicroService
 * InvalidCredentialException => method for handling Wrong Credential Exception
 * InvalidUserException => method for handling user not found Exception 
 ***********************************************************************/
@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private Environment env;
	
	/*
	 * InvalidCredentialExcetioon will handle the LoginFailedException 
	 * which mean that Login Credentials you entered are wrong it will 
	 * set value in ErrorResponse POJO class and it as response 
	 */
	@ExceptionHandler(LoginFailedException.class)
	public ResponseEntity<ErrorResponse> InvalidCredentialException(
			LoginFailedException loginFailedException) {
		log.info(env.getProperty("log.start"));
		ErrorResponse response = new ErrorResponse();
		response.setDatetime(LocalDateTime.now());
		response.setMessage(loginFailedException.getMessage());
		response.setStatus(HttpStatus.FORBIDDEN);
		response.setDescription(env.getProperty("ex.loginfail.desc"));
		log.debug(env.getProperty("ex.eResponse"), response);
		log.info(env.getProperty("log.end"));
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.FORBIDDEN);
	}
	
	/*
	 * InvalidUserException will handle the UserNotFoundException 
	 * which mean that User that you entered are might to present in database it will 
	 * set value in ErrorResponse POJO class and it as response 
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> InvalidUserException(
			UserNotFoundException userNotFoundException) {
		log.info(env.getProperty("log.start"));
		ErrorResponse response = new ErrorResponse();
		response.setDatetime(LocalDateTime.now());
		response.setMessage(userNotFoundException.getMessage());
		response.setStatus(HttpStatus.FORBIDDEN);
		response.setDescription(env.getProperty("ex.usernotfound.desc"));
		log.debug(env.getProperty("ex.eResponse"), response);
		log.info(env.getProperty("log.end"));
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.FORBIDDEN);
	}
}
