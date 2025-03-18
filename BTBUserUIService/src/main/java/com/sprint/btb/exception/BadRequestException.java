package com.sprint.btb.exception;



public class BadRequestException extends RuntimeException {

    private String message;

    // Constructor that takes only the error message
    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    // Getters and setters (optional, depending on how you want to use the exception)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
