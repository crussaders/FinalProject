package com.PharmacySupply.AuthenticationService.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
/*******************************************************
 * ErrorReponse class is use to sent the errorResponse
 * when error occur in MicroService it is use by GlobalErrorHandler
********************************************************/
public class ErrorResponse {

	private HttpStatus status;
	private String message;
	private String description;
	private LocalDateTime datetime;
}
