package com.internaltools.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internaltools.payload.request.ClientMasterRequest;
import com.internaltools.payload.request.UserCreateRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.entity.ClientMaster;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.service.UserService;
import com.internaltools.util.ErrorConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
@Override
	public ApiResponse createUser(@Valid UserCreateRequest request) {
	ApiResponse response = new ApiResponse();
	
	try
	{
	User user = new User();
		
		User.setEmail(request.getUserCreateModel().getEmail());
		
		
	}
catch(Exception e) {
	log.error("Exception in transferFromManualTransaction :: " + e.getMessage());
	response.setStatus(false);
	response.setMessage("Failure");
	response.setStatusCode(ErrorConstants.ERROR_CODE_401);
	return response;
	
}

response.setStatus(true);
response.setMessage("Success");
response.setStatusCode(ErrorConstants.ERROR_CODE_200);
return response;
}
}