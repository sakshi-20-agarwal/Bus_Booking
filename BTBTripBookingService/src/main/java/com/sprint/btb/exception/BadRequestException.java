package com.sprint.btb.exception;

public class BadRequestException extends Exception{

	String message;
	public BadRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public BadRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
