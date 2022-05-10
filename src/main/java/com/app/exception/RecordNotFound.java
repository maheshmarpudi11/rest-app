package com.app.exception;

public class RecordNotFound extends RuntimeException{

	private String message;

	public RecordNotFound(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	
}
