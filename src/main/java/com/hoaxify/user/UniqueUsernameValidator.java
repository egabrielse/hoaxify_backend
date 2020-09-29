package com.hoaxify.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	
	@Autowired
	UserRepository userRepository;
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (this.userRepository.findByUsername(value) == null) {
			return true;
		} else {
			return false;
		}
	}

}
