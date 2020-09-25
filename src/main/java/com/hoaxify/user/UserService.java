package com.hoaxify.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	/*
	 * The userRepository is initialized via constructor injection for easier testing.
	 */
	UserRepository userRepository;
	
	BCryptPasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = new 	BCryptPasswordEncoder();
	}
	
	public User save(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return this.userRepository.save(user);
	}

}
