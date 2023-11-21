package com.example.ToDo.List.App.exception;

/**
 * Custom Exception class created for ResourceNotFoundException
 * 
 * @author Aravind
 *
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9079454849611061074L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
