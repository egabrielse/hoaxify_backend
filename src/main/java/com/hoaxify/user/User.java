package com.hoaxify.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data // Lombok - Auto creates boiler plate code (getters,setters,constructors)
@Entity // Data JPA - Used for mapping an object to a database table
public class User {
	
	@Id // Data JPA - Signifies that this is the key/id value for the database row
	@GeneratedValue // Data JPA - Auto generates unique id values for the key
	private long id;
	private String username;
	private String displayName;
	private String password;

}
