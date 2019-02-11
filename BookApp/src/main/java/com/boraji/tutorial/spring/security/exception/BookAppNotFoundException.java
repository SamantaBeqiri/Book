package com.boraji.tutorial.spring.security.exception;
import com.boraji.tutorial.spring.security.exception.NotFound;;


public class BookAppNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public BookAppNotFoundException(NotFound notFound) {
		super(notFound.getMessage());
	}
		
	}


