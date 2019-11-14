package com.pupil.assignment.view;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class UserResponse{
	private HttpStatus statusCode;
	private  Date date;
	private String errorMsg;
	
	public UserResponse(HttpStatus statusCode, Date date, String errorMsg) {
		super();
		this.statusCode = statusCode;
		this.date = date;
		this.errorMsg = errorMsg;
	}
	
	
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
