package com.cognizant.pharmacysupply.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.pharmacysupply.model.ErrorResponse;


/**
 * This Class Handles All the Global Exception and the Specified Exceptions
 */
@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler{
	
	/**
	 *  Method Name --> handleAllErrors
	 *  @param      --> Global Exception 
	 *  @return     --> Error Response
	 *  This method takes Global Exception as input provide Error response as output.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllErrors(Exception ex) {
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setReason("Bad request");
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	

	/**
	 *  Method Name --> handleMedicineNotFoundException
	 *  @param      --> Medicine Not Found Exception 
	 *  @return     --> Error Response for Medicine Not found
	 *  This method takes MedicineNotFound Exception as input and provides the Error Response of Medicine Not 
	 *  Found Exception with respective message and reason.
	 */
	
	@ExceptionHandler(MedicineNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleMedicineNotFoundException(MedicineNotFoundException medicineNotFoundException) {
		ErrorResponse customErrorResponse = new ErrorResponse();
		customErrorResponse.setStatus(HttpStatus.FORBIDDEN);
		customErrorResponse.setMessage(medicineNotFoundException.getMessage());
		customErrorResponse.setReason("You might have entered wrong medicine name or the medicine may be out of stock.");
		customErrorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(customErrorResponse, HttpStatus.FORBIDDEN);
	}
	
	/**
	 *  Method Name --> handleTokenValidationFailedException
	 *  @param      --> Token Validation Fail Exception 
	 *  @return     --> Error Response for Token Validation Fail
	 *  This method takes Token Validation Fail Exception as input and provides the Error Response of 
	 *  Token Validation Fail Exception with respective message and reason.
	 */
	@ExceptionHandler(TokenValidationFailedException.class)
	public ResponseEntity<ErrorResponse> handleTokenValidationFailedException(TokenValidationFailedException tokenValidationFailedException) {
		ErrorResponse customErrorResponse = new ErrorResponse();
		customErrorResponse.setStatus(HttpStatus.FORBIDDEN);
		customErrorResponse.setMessage(tokenValidationFailedException.getMessage());
		customErrorResponse.setReason("YOUR TOKEN MIGHT BE WRONG OR MAYBE EXPIRED");
		customErrorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(customErrorResponse, HttpStatus.FORBIDDEN);
	}
	
}
