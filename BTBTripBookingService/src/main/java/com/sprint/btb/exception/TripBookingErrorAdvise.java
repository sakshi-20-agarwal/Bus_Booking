package com.sprint.btb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
 
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TripBookingErrorAdvise {
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {Exception.class})
	protected ErrorInfo handleConflict(BadRequestException ex, HttpServletRequest req) 
	{
		String bodyResponse = ex.getMessage();
		String uri = req.getRequestURI().toString();
		ErrorInfo ei = new ErrorInfo(uri,bodyResponse);
		System.out.println("------handleConflict Executed---:" +ei);
		return ei;
	}

}
