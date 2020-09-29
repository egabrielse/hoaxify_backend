package com.hoaxify.user;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.error.ApiError;
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
	GenericResponse createUser(@Valid @RequestBody User user) {
		// @RequestBody annotation tells spring that this method wants the request body of the incoming message.
		// This is followed by the object the method is waiting for.

		
		// Instead of checking each thing, use the built-in constraints from bean validation (see @Validated and User class)
		/*if (user.getUsername() == null || user.getDisplayName() == null) {
			throw new UserIsNotValidException();
		}*/
		userService.save(user);

		// Return a successful generic response message:
		return new GenericResponse("User saved!");
	}
	
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ApiError handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request) {
		ApiError apiError = new ApiError(400, "Validation error", request.getServletPath());
		
		BindingResult result = exception.getBindingResult();
		
		Map<String,String> validationErrors = new HashMap<>();
		
		for (FieldError fieldError : result.getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		apiError.setValidationErrors(validationErrors);
		 
		return apiError;
	}

}
