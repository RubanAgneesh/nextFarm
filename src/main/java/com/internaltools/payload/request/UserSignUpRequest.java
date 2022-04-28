package com.internaltools.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpRequest {
    
	private String title;
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String countryCode;
	
	private String mobileNumber;
	
	private String imageUrl;
	
	private String imageKey;
	
	private String country;
	
	private String timeZone;
	
	private Integer otp;
	
	private Long companyId;
	
}
