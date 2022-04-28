package com.internaltools.payload.response;

import java.util.List;

import com.internaltools.service.model.ConfigPropertiesModel;

import lombok.Data;

@Data
public class ConfigPropertyResponse extends ApiResponse {
    
	private static final long serialVersionUID = 1L;
	
	private List<ConfigPropertiesModel> configPropertiesModelList; 
}
