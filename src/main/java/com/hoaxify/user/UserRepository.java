package com.hoaxify.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	// Format : findBy ColumnName Containing {optional} (Object columnValue)
	// Examples: 
	// List<User> findByUsernameContaining(String username);
	// User findByUsernameAndDisplayName(String username, String displayName);
	
	User findByUsername(String username);
	
}
