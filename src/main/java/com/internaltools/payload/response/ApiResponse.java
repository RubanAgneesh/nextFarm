package com.internaltools.payload.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Boolean status;
    
	private String message;
	
	private String statusCode;
	
}
