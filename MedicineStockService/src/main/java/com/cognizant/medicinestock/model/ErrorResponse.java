package com.cognizant.medicinestock.model;


/* This is a ErrorResponse POJO Class with  attributes like localDateTime,status,reason and message */
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class ErrorResponse {
    
	private LocalDateTime localDateTime;
	private HttpStatus status;
	private String reason;
	private String message;
	
}
