package com.imcs.rest.webservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imcs.rest.webservices.dao.UserRepository;
import com.imcs.rest.webservices.entity.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		User user=userRepo.findUserByUsernameAndPassword(username, password);
		return user;
		
	}

	@Override
	public List<User> findAll() {
		List<User> users=(List<User>) userRepo.findAll();
		return users;
	}

	@Override
	public Optional<User> findUserById(Integer id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}

	@Override
	public void saveUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}

}
