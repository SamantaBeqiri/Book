package com.boraji.tutorial.spring.security.exception;

public class BookAppBadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = -3501410652768142933L;

	public BookAppBadRequestException(String message) {
		super(message);
	}

}
