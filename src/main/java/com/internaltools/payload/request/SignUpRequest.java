package com.internaltools.payload.request;

import com.internaltools.service.model.UserCreateModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    
	private String firstName;
	
	private String lastName;
	
	private String userEmailId;
	
	private String password;

	private String voterId;

	private String aadharNumber;

	private String aadharName;

	private String mobileNumber;

	private String gender;

	private String fatherName;

	private String country;

	private String state;

	private String district;

	private String village;

	private String pinCode;

	private String assemblyConstituency;
    private String companyName;
    
    private String countryName;
    
    private String currency;

	public Integer otp;

	private String imageUrl;

	private String imageKey;

	private Long countryId;
	
	private Long currencyId;

	private String imagePath;

	UserCreateModel userCreateModel;
}
