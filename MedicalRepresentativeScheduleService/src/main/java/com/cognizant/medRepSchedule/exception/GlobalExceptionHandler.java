package com.cognizant.medRepSchedule.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.medRepSchedule.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	ErrorResponse errorResponse;

	@Autowired
	private Environment env;

	/*
	 * This method is responsible for handling all Exceptions. InputParameter ->
	 * Exception execption. OutputParameter ->ResponseEnity as status of BAD_REQUEST
	 * in format of ErrorResponse Class.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllException(Exception exception) {
		log.info(env.getProperty("log.start"));

		errorResponse.setMessage(exception.getMessage());
		errorResponse.setReason("BAD_REQUEST");
		errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setTimestamp(LocalDateTime.now());

		log.info(env.getProperty("log.end"));

		return ResponseEntity.badRequest().body(errorResponse);
	}
	/*
	 * This method is responsible for handling Invalid dates entered by user.
	 * InputParameter -> InvalidDateException dateException. OutputParameter
	 * ->ResponseEnity as status of NOT_FOUND in format of ErrorResponse Class.
	 */
	@ExceptionHandler(InvalidDateException.class)
	public ResponseEntity<ErrorResponse> handleDateNotFoundException(InvalidDateException dateException) {
		log.info(env.getProperty("log.start"));

		errorResponse.setMessage(dateException.getMessage());
		errorResponse.setReason("You need to provide date in dd-MM-yyyy format");
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setTimestamp(LocalDateTime.now());

		log.info(env.getProperty("log.end"));

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	/*
	 * This method is responsible for handling token validation. InputParameter ->
	 * InvalidTokenException tokenException. OutputParameter ->ResponseEnity as
	 * status of FORBIDDEN in format of ErrorResponse Class.
	 */
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<ErrorResponse> handleTokenValidationFailedException(InvalidTokenException tokenException) {
		log.info(env.getProperty("log.start"));

		errorResponse.setMessage("Your token might have been expired or you have entered wrong token");
		errorResponse.setReason("Your token might have been expired or you have entered wrong token");
		errorResponse.setStatus(HttpStatus.FORBIDDEN);
		errorResponse.setTimestamp(LocalDateTime.now());

		log.info(env.getProperty("log.end"));

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
	}
}
