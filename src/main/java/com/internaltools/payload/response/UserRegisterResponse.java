package com.internaltools.payload.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse extends ApiResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Boolean alreadyRegistered;
	
	private Boolean partiallyRegistered;
	
	private Boolean exceedOtpCount;
	
}
