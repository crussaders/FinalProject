package com.cognizant.medRepSchedule.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class InvalidDateExceptionTest {

	@Mock
	private InvalidDateException dateNotFound;
    /*
     * checking for invalid date message. 
     * */
	@Test
	public void testInvalidDateMessage() {
		InvalidDateException exception = new InvalidDateException("Invalid date.");
		assertEquals("Invalid date.", exception.getMessage());
	}
	/*
     * checking for invalid date null message. 
     * */
	@Test
	public void testInvalidDate() {
		InvalidDateException exception = new InvalidDateException();
		assertEquals(null, exception.getMessage());
	}

}
