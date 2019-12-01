package com.ezeon.capp.exception;

@SuppressWarnings("serial")
public class UserBlockedException extends Exception{

	/*
	 * Creates User object without error description
	 */
	public UserBlockedException() {

	}

	/*
	 * Creates User object with error description
	 */
	public UserBlockedException(String errorDescription) {
		super(errorDescription);
	}
}
