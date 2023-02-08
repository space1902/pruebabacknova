package com.prueba.response;

import java.util.List;

import com.prueba.model.User;


public class UserResponse {
	
	private List<User> asesor;

	public List<User> getUser() {
		return asesor;
	}

	public void setUser(List<User> asesor) {
		this.asesor = asesor;
	}
}
