package com.hoaxify.shared;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok
@NoArgsConstructor // Lombok
public class GenericResponse {
	private String message;
	
	public GenericResponse(String message) {
		this.message = message;
	}

}
