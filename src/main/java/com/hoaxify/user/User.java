package com.hoaxify.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data // Lombok - Auto creates boiler plate code (getters,setters,constructors)
@Entity // Data JPA - Used for mapping an object to a database table
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
	
	@Id // Data JPA - Signifies that this is the key/id value for the database row
	@GeneratedValue // Data JPA - Auto generates unique id values for the key
	private long id;
	
	
	@NotNull
	@Size(min = 4, max = 255)
	@UniqueUsername
	private String username;
	
	@NotNull
	@Size(min = 4, max = 255)
	private String displayName;
	
	@NotNull
	@Size(min = 8, max = 255)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$") // one lower, one upper, one digit
	private String password;

}
