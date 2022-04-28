package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigPropertiesModel {

	private Long configPropertyId;

	private String configName;
	
	private String configDescription;
	
	private String configValue;
	
	private boolean isActive;
	
}
