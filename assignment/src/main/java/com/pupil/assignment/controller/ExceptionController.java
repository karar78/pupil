package com.pupil.assignment.controller;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.pupil.assignment.view.DataInputException;
import com.pupil.assignment.view.UserResponse;

@ControllerAdvice
@RestController
public class ExceptionController {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> handleException(Exception e){
	
		if(e instanceof DataInputException) {
			DataInputException die = (DataInputException) e;
			return new ResponseEntity<UserResponse>(new UserResponse(die.getHttpStatus(), new Date(), e.getMessage()), die.getHttpStatus());
		}
		
		return null;
	}
}
