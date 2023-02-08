package com.prueba.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.dao.IUserDao;
import com.prueba.model.User;
import com.prueba.response.UserResponseRest;


@Service
public class UserServicesImpl implements IUserService{

		private IUserDao userDao;

		public UserServicesImpl(IUserDao userDao) {
			this.userDao = userDao;
		}

		@Override
		public ResponseEntity<UserResponseRest> CreateUser( User user) {

			UserResponseRest response = new UserResponseRest();
			List<User> list = new ArrayList<>();

			try {
				User userSaved = userDao.save(user);

				if(userSaved != null) {

					list.add(userSaved);
					response.getUserResponse().setUser(list);;
					response.setMetadata("Respuesta ok", "00", "usuario creado correctamente");

				}else {

					response.setMetadata("Respuesta no ok", "-1", "Usuario no creado");
					return new ResponseEntity<UserResponseRest>(response, HttpStatus.BAD_REQUEST);
				}


			} catch (Exception e) {
				// TODO: handle exception
				response.setMetadata("Respuesta no ok", "-1", "Error al crear al Usuario");
				e.getStackTrace();
				return new ResponseEntity<UserResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<UserResponseRest>(response, HttpStatus.OK);
		}

		@Override
		public ResponseEntity<UserResponseRest> GetUsers() {

			UserResponseRest response = new UserResponseRest();

			try {

				List<User> user = (List<User>) userDao.findAll();

				response.getUserResponse().setUser(user);
				response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

			} catch (Exception e) {
				// TODO: handle exception
				response.setMetadata("Respuesta no ok", "-1", "Respuesta no exitosa");
				e.getStackTrace();
				return new ResponseEntity<UserResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<UserResponseRest>(response, HttpStatus.OK);
		}

}
