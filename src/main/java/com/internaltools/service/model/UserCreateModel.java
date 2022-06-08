package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserCreateModel {
	
	private String email;

	private String password;
	
	private int roleId;
	
	private Long companyId;
	
	private String token;
	
	private Boolean active;
	
	

}
