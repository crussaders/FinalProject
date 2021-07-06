package com.cognizant.medRepSchedule.exception;

public class InvalidTokenException extends Exception {

	/*
	 * This is the number that will help the JVM to identify the state of an object
	 * when it reads the state of the object from a file.
	 **/
	private static final long serialVersionUID = 1L;

	/*
	 * Default constructor for Invalid token Exception.
	 **/
	public InvalidTokenException() {
		super();
	}
	/*
	 * Parameterised constructor for Invalid token Exception to print user defined
	 * messages. InputParameter -> String exception message. String exception
	 * message will be passed to parent Class.
	 **/
	public InvalidTokenException(String ErrorMessage) {
		super(ErrorMessage);
	}
}
