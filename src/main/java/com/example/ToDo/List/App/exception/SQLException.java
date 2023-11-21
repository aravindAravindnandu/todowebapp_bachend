package com.example.ToDo.List.App.exception;

/**
 * Custom exception for SQLException
 * 
 * @author Aravind
 *
 */
public class SQLException extends RuntimeException {

	private static final long serialVersionUID = -9079454849611061074L;

	public SQLException() {
		super();
	}

	public SQLException(String msg) {
		super(msg);
	}

}
