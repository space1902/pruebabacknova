package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.User;
import com.prueba.response.UserResponseRest;
import com.prueba.services.IUserService;

@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@RequestMapping("api/v1/")
public class UserRestController {

		
		@Autowired
		private IUserService userService;
		
		@GetMapping("searchusers")
		public ResponseEntity<UserResponseRest> GetUsers(){

			ResponseEntity<UserResponseRest> response = userService.GetUsers();

			return response;

		}
		
		@PostMapping("createuser")
		public ResponseEntity<UserResponseRest> CreateUser(@RequestBody User user){

			ResponseEntity<UserResponseRest> response = userService.CreateUser(user);

			return response;

		}
}
