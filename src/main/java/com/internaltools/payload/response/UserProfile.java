package com.internaltools.payload.response;

import java.util.Date;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile extends ApiResponse {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String title;
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	@Email
	private String email;
	
	private String password;
	
	private String countryCode;
	
	private String mobileNumber;
	
	private String imageUrl;
	
	private String imageKey;
	
	private String country;
	
	private String timeZone;
	
	private Integer otp;
	
    private Date dateOfBirth;
	
	private boolean isActive; 
	
	private boolean isDeleted;
	
	private String gender;

}
