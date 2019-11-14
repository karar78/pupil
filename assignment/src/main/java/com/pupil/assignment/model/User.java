package com.pupil.assignment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints={
	    @UniqueConstraint(columnNames = {"firstName", "lastName"})
	}) 
public class User { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long id;
	

	@Size(min=2, message = "must contain atleast 2 characters")
	private String firstName;
	
	@Size(min=2, message = "must contain atleast 2 characters")
	private String lastName;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date registrationDate;
	 
	protected User() {
		super();
		registrationDate = new Date();
	}
	
	
	public User(String firstName, String lastName, Date registrationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationDate = registrationDate;
	}

	public long getId() {
		return id;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", registrationDate="
				+ registrationDate + "]";
	}
}
