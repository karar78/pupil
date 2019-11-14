package com.pupil.assignment.view;

import org.springframework.http.HttpStatus;

public class DataInputException extends RuntimeException {

private HttpStatus httpStatus;
	private static final long serialVersionUID = 1L;

	public DataInputException() {
		super();
	}

	public DataInputException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
