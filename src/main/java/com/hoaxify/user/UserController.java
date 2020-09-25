package com.hoaxify.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.shared.GenericResponse;

@RestController
public class UserController {
	
	
	/*
	 * According to tutorial:
	 * At controller level unit testing is not needed, therefore the userService is autowired.
	 */
	@Autowired
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	GenericResponse createUser(@RequestBody User user) {
		// @RequestBody annotation tells spring that this method wants the request body of the incoming message.
		// This is followed by the object the method is waiting for.
		
		userService.save(user);

		// Return a successful generic response message:
		return new GenericResponse("User saved!");
	}

}
