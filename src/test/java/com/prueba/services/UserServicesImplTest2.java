package com.prueba.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.prueba.controller.UserRestController;
import com.prueba.model.User;
import com.prueba.response.UserResponseRest;

class UserServicesImplTest2 {

	@Mock
	private IUserService userService;

	@InjectMocks
	private UserRestController userRestController;;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void saveTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		User user = new User();
		user.setName("victor");
		user.setLastName("ortiz");
		user.setIdUser(1L);
		user.setEmail("victor@gmai.com");
		user.setCargo("estudiante");
		

		when(userService.CreateUser(any(User.class))).thenReturn(new ResponseEntity<UserResponseRest>(HttpStatus.OK));
		ResponseEntity<UserResponseRest> response = userRestController.CreateUser(user);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	void getTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		User user = new User();
		user.setName("victor");
		user.setLastName("ortiz");
		user.setIdUser(1L);
		user.setEmail("victor@gmai.com");
		user.setCargo("estudiante");

		ResponseEntity<UserResponseRest> creado = userService.CreateUser(user);

		when(userService.GetUsers()).thenReturn(new ResponseEntity<UserResponseRest>(HttpStatus.OK));
		assertEquals(userService.GetUsers().getBody(), creado);
	}
}
