package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleMasterModel {
	
	private Long id;
	
	private String roleName;

	private String description;
	
	private boolean hidden;
	
	private Long userId;
	
	private boolean active;
	
}
