package com.internaltools.payload.response;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListResponse extends ApiResponse {
	
	private static final long serialVersionUID = 1L;
	
	List<UserProfile> userProfileList;
	
	Set<UserProfile> userProfilesList;
	
}
