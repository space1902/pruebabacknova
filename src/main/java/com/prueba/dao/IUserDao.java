package com.prueba.dao;

import org.springframework.data.repository.CrudRepository;

import com.prueba.model.User;


public interface IUserDao extends CrudRepository<User, Long>{

}
