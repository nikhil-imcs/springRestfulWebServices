package com.imcs.rest.webservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.rest.webservices.entity.User;
import com.imcs.rest.webservices.exceptions.UserNotFoundException;
import com.imcs.rest.webservices.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserService userService;

	@SuppressWarnings("unchecked")
	@GetMapping(path = "")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity(userService.findAll(), HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
		Optional<User> user = userService.findUserById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not found with id->" + id);
		} else {
			return new ResponseEntity(user, HttpStatus.OK);
		}

	}

	@PostMapping(path = "")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@PutMapping(path = "")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	@PostMapping(path = "/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		User foundUser = userService.findUserByUsernameAndPassword(username, password);
		if (foundUser == null) {
			throw new UserNotFoundException("Authentication failed, Please try again!");
		} else {
			return new ResponseEntity(foundUser, HttpStatus.ACCEPTED);

		}

	}

}
