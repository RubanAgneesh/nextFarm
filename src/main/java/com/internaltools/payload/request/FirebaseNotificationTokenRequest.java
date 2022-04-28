package com.internaltools.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirebaseNotificationTokenRequest {
	
	private String username;
	
	private String uuid;
	
	@NotBlank
	private String firebaseNotificationToken;
	
	private Boolean status;
}
