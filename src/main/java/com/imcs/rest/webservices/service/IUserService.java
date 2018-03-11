package com.imcs.rest.webservices.service;

import java.util.List;
import java.util.Optional;

import com.imcs.rest.webservices.entity.User;

public interface IUserService {
	
	User findUserByUsernameAndPassword(String username, String password);
	
	List<User> findAll();
	
	Optional<User> findUserById(Integer id);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(Integer id);

}
