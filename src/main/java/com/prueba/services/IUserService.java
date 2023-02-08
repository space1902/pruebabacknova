package com.prueba.services;

import org.springframework.http.ResponseEntity;

import com.prueba.model.User;
import com.prueba.response.UserResponseRest;


public interface IUserService {

	public ResponseEntity<UserResponseRest> CreateUser(User user);
	public ResponseEntity<UserResponseRest> GetUsers();
}
