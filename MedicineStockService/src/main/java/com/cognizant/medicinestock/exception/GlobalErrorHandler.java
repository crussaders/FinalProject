package com.cognizant.medicinestock.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.medicinestock.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

/* This is an global exception handler class which handle the exceptions */
@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler{
	
    /* This method handles all exceptions like null pointer,array out of bound  exceptions and print the below messages 
      * InputParameter -> causing exception, OutputParameter ->String exception message will be printed
	
	 **/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> allExceptions(Exception exception) {
		log.info("START");
		ErrorResponse response = new ErrorResponse();
		response.setLocalDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setReason("BAD REQUEST");
		log.debug("ERROR RESPONSE {}:", response);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	/* This method  handle token validation failed exception  and print the below messages in the postman
	 *  * InputParameter ->wrong token, OutputParameter ->String exception message will be printed */
	@ExceptionHandler(TokenValidationFailedException.class)
	public ResponseEntity<ErrorResponse> handleTokenValidationFailedException(TokenValidationFailedException exception) {
		log.info("START");
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.FORBIDDEN);
		errorResponse.setMessage("PLEASE ENTER VALID TOKEN");
		errorResponse.setReason("YOUR TOKEN MIGHT BE WRONG OR MAYBE EXPIRED");
		errorResponse.setLocalDateTime(LocalDateTime.now());
		log.info("END");
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
	}
	
	/* This method handle medicine not found exception and print the below messages in the postman
	 *  * InputParameter ->wrong medicine name, OutputParameter ->String exception message will be printed */
	@ExceptionHandler(MedicineNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleMedicineNotFoundException(MedicineNotFoundException exception) {
		log.info("Start");
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("Medicine Not Found");
		errorResponse.setReason("You need to provide correct medicine name");
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setLocalDateTime(LocalDateTime.now());

		log.info("End");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	/* This method handle treating ailment not found  exception and print the below messages in the postman
	 *  * InputParameter ->wrong treating ailment, OutputParameter ->String exception message will be printed */
	
	@ExceptionHandler(TreatingAilmentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleTreatingAilmentNotFoundException(TreatingAilmentNotFoundException exception) {
		log.info("Start");
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("Treating Ailment Not Found");
		errorResponse.setReason("You need to provide correct treating ailment");
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setLocalDateTime(LocalDateTime.now());

		log.info("End");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}


	
}
