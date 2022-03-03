package com.getarrays.employees.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}
}
