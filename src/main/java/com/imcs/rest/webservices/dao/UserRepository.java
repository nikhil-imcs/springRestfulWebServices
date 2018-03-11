package com.imcs.rest.webservices.dao;

import org.springframework.data.repository.CrudRepository;

import com.imcs.rest.webservices.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findUserByUsernameAndPassword(String username, String password);
	
	

}
