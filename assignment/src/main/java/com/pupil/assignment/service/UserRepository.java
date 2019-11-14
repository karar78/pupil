package com.pupil.assignment.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.pupil.assignment.model.User;
@Component
public interface UserRepository extends CrudRepository<User, Long> {

}
