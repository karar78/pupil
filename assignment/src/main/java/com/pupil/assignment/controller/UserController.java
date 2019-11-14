package com.pupil.assignment.controller;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pupil.assignment.model.User;
import com.pupil.assignment.service.UserRepository;
import com.pupil.assignment.view.DataInputException;
import com.pupil.assignment.view.UserResponse;

@RestController
public class UserController {
	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository service;

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUser(@PathVariable long id) throws DataInputException {
		Optional<User> obj = service.findById(id);
		LOGGER.debug("Object found: " +obj.toString());
		
		return new ResponseEntity(obj.orElseThrow(() -> new DataInputException("No user found with ID:  " + id, HttpStatus.NOT_FOUND)), HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user, Errors results) {
		
		
		if(results.hasFieldErrors()) {
			FieldError fieldError = results.getFieldError();
			UserResponse response = new UserResponse(HttpStatus.NOT_ACCEPTABLE, new Date(), fieldError.getField() + ": " + fieldError.getDefaultMessage());
			return new ResponseEntity(response, HttpStatus.NOT_ACCEPTABLE);
		}
		
		User savedUser = null;
		try {
		savedUser = service.save(user);
		}
		catch(DataIntegrityViolationException e) {
			LOGGER.error(e.getMessage());
			throw new DataInputException("User " + user.getFirstName() + " " + user.getLastName() + " has already been registered, unable to re-register this user !", HttpStatus.CONFLICT);
		}
		
		UserResponse response = new UserResponse(HttpStatus.OK, new Date(), "User registered successfully with id: " + savedUser.getId());
		  URI location = ServletUriComponentsBuilder .fromCurrentRequest()
		  .path("/{id}") .buildAndExpand(savedUser.getId()).toUri(); 
		  return new ResponseEntity(response, HttpStatus.OK);
		
	}
}
