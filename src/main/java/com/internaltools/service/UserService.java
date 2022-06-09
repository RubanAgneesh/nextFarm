package com.internaltools.service;

import javax.validation.Valid;

import com.internaltools.payload.request.UserCreateRequest;
import com.internaltools.payload.response.ApiResponse;



/**
 * @author Pirai
 *
 */
public interface UserService {

	ApiResponse createUser (@Valid UserCreateRequest request);

	
}
