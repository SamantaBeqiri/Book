package com.boraji.tutorial.spring.security.exception;

public enum NotFound {
USER("User not found"),BOOK("Book not found");
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	private NotFound(String message) {
		
		this.message=message;
	}

}
