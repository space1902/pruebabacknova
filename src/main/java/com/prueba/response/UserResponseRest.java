package com.prueba.response;

import lombok.Data;

@Data
public class UserResponseRest extends ResponseRest{


	private UserResponse userResponse = new UserResponse();
	
	public UserResponse getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}

}
