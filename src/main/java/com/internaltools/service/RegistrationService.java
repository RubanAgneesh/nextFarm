package com.internaltools.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.internaltools.exception.AppException;
import com.internaltools.payload.request.SignUpRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.UserRegisterResponse;

public interface RegistrationService {
	
	/**
	 * @param signUpRequest
	 * @return UserRegisterResponse
	 */
	UserRegisterResponse validateSignUpEmail(@NotNull @Valid SignUpRequest signUpRequest);

	/**
	 * @param signUpRequest
	 * @return UserRegisterResponse
	 */
	UserRegisterResponse sendSignUpOTP(@Valid SignUpRequest signUpRequest);

	/**
	 * @param signUpRequest
	 * @return UserRegisterResponse
	 */
	UserRegisterResponse reSendSignUpOTP(@Valid SignUpRequest signUpRequest);

	/**
	 * @param token
	 * @param email
	 * @return ApiResponse
	 * @throws AppException
	 */
	ApiResponse verifyOtp(@NotNull Integer token, String email) throws AppException;
	
	/**
	 * @param completeRegistrationRequest
	 * @return ApiResponse
	 */
	UserRegisterResponse completeRegistrationProcess(@Valid SignUpRequest completeRegistrationRequest);
}
