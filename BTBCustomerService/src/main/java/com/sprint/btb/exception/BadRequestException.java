package com.sprint.btb.exception;

public class BadRequestException extends Exception {
	 String message;
	public BadRequestException() {
		super();
	}
 
	public BadRequestException(String message) {
		super(message);
	}
 
}
