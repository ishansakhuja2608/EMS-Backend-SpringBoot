// Creating a custom exception

package com.fullstack.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // adding here, instead of adding this annotation to each REST API
public class ResourceNotFoundException extends RuntimeException {
	
	// Constructor
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
