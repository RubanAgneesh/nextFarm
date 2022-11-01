package com.internaltools.service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.internaltools.exception.AppException;
import com.internaltools.payload.request.LoginRequest;
import com.internaltools.payload.request.SignUpRequest;
import com.internaltools.payload.request.UserCreateRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.UserProfile;


/**
 * @author Pirai
 *
 */
public interface UserService {

	/**
	 * @param usernameOrEmail
	 * @return ApiResponse
	 */
	ApiResponse sendResetPasswordOtp(String usernameOrEmail);

	/**
	 * @param token
	 * @param userEmailId
	 * @return ApiResponse
	 * @throws AppException
	 */
	ApiResponse verifyResetPasswordOtp(@NotNull Integer token, String userEmailId) throws AppException;
	
	/**
	 * @param signUpRequest
	 * @return ApiResponse
	 */
	ApiResponse completeResetPasswordProcess(SignUpRequest signUpRequest);

	/**
	 * @param request
	 * @return UserProfile
	 */
	UserProfile getUserProfile(@Valid SignUpRequest request);

	/**
	 * @param request
	 * @param servletRequest
	 */
	void logoutUser(@Valid SignUpRequest request, HttpServletRequest servletRequest);

	/**
	 * @param request
	 * @return ApiResponse
	 */
	ApiResponse updateUserProfile(@Valid SignUpRequest request);

	/**
	 * @param request
	 * @return
	 */
	ApiResponse createUser(@Valid UserCreateRequest request);
	
	/**
	 * @param request
	 * @return
	 */
	ApiResponse userlogin(@Valid LoginRequest login);


    ApiResponse approvalFlow(String usernameOrEmail);
}