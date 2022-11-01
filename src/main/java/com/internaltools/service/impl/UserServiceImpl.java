package com.internaltools.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.internaltools.config.email.NextFarmEmailConfigurations;
import com.internaltools.exception.ResourceNotFoundException;
import com.internaltools.persistence.entity.ResetUserPassword;
import com.internaltools.persistence.entity.UserToken;
import com.internaltools.persistence.repository.ResetUserPasswordRepository;
import com.internaltools.service.TokenService;
import com.internaltools.service.model.UserCreateModel;
import com.internaltools.util.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.internaltools.exception.AppException;
import com.internaltools.payload.request.LoginRequest;
import com.internaltools.payload.request.SignUpRequest;
import com.internaltools.payload.request.UserCreateRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.UserProfile;
import com.internaltools.persistence.entity.User;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.service.UserService;
import com.internaltools.util.ErrorConstants;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	TokenService tokenService;

	@Autowired
	CommonUtils commonUtils;

	@Autowired
    NextFarmEmailConfigurations emailConfig;

	@Autowired
	ResetUserPasswordRepository resetUserPasswordRepository;

	@Autowired
	PasswordEncoder passwordEncoder;


	@Override
	public ApiResponse createUser(@Valid UserCreateRequest request) {
		ApiResponse response = new ApiResponse();
		UserCreateModel usercreatemodel = request.getUserCreateModel();
		
		
			try {
				User user = new User();
				//BeanUtils.copyProperties(usercreatemodel, user);
				
				user.setFirstName(request.getUserCreateModel().getFirstName());
				user.setLastName(request.getUserCreateModel().getLastName());
				user.setPassword(request.getUserCreateModel().getPassword());
				user.setMobileNumber(request.getUserCreateModel().getMobileNumber());
				user.setImageKey(request.getUserCreateModel().getImageKey());
				user.setImageUrl(request.getUserCreateModel().getImageUrl());
				userRepository.save(user);
				
//				if (null == request.getUserCreateModel().getEmail()) {
//					response.setMessage("Email is mandatory");
//					response.setStatus(Boolean.FALSE);
//					response.setStatusCode(ErrorConstants.ERROR_CODE_401);
//					return response;
//				}
//					
//				
//				if (null == request.getUserCreateModel().getPassword()) {
//					response.setMessage("Password is mandatory");
//					response.setStatus(Boolean.FALSE);
//					response.setStatusCode(ErrorConstants.ERROR_CODE_401);
//					return response;
//				}
				
				
				
			} catch (Exception e) {
				log.error("Exception in Company ::" + e.getMessage());
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

	@Override
	public void logoutUser(@Valid SignUpRequest request, HttpServletRequest servletRequest) {

		Optional<User> user = userRepository.findByUserEmailId(
				(null != request.getFirstName() ? request.getFirstName().toLowerCase() : request.getFirstName()));
		if (user.isEmpty()) {
			new ResourceNotFoundException("User", "username", request.getFirstName());
		}
		Optional<String> token = CommonUtils.getJwtFromRequest(servletRequest);
		if (token.isPresent()) {
			Optional<UserToken> userToken = tokenService.findByToken(token.get());
			UserToken userTokenInfo = userToken.get();
		//	userTokenInfo.setModifiedBy(user.get().getFirstName());
			userTokenInfo.setIsActive("N");
			tokenService.saveUserToken(userTokenInfo);
		}
	}
	@Override
	public ApiResponse sendResetPasswordOtp(String usernameOrEmail) {
		if (null != usernameOrEmail) {
			usernameOrEmail = usernameOrEmail.toLowerCase();
		}

		Optional<User> userEntity = userRepository.findByUserEmailId(usernameOrEmail);
		if (!userEntity.isPresent()) {
			return ApiResponse.builder().status(Boolean.FALSE).message("Invalid Username.").statusCode("ERROR_CODE_401").build();
		}

		try {
			User user = userEntity.get();
			if (!user.isRegistered()) {
				return ApiResponse.builder().status(Boolean.FALSE).message("User not completed registration.").build();
			}
			commonUtils.createResetPasswordOtp.accept(user);
			commonUtils.sendEmail.accept(emailConfig.resetPasswordEmail.apply(user));
			return ApiResponse.builder().status(Boolean.TRUE).message("Password OTP Sent.").statusCode("ERROR_CODE_200").build();
		} catch (Exception e) {
			log.debug("Exception {} while creating password rest token for email id:" + usernameOrEmail,
					e.getMessage());
			return ApiResponse.builder().status(Boolean.FALSE)
					.message("Unable to reset your password. Please try again later.").statusCode("400").build();
		}
	}

	@Override
	public ApiResponse verifyResetPasswordOtp(@NotNull Integer token, String userEmailId) throws AppException {
		if (null != userEmailId) {
			userEmailId = userEmailId.toLowerCase();
		}
		ResetUserPassword resetUserPassword = null;
		final Optional<ResetUserPassword> otp = resetUserPasswordRepository.findByOtpAndOtpValidAndUserUserEmailId(token,
				true, userEmailId);
		if (otp.isEmpty()) {
			return new ApiResponse(false, "The Given Otp is Invalid " + token, ErrorConstants.ERROR_CODE_401);
		}

		resetUserPassword = otp.get();
		resetUserPassword.setOtpValid(false);
		resetUserPasswordRepository.save(resetUserPassword);
		return new ApiResponse(true, "Otp successfully authenticated", ErrorConstants.ERROR_CODE_200);
	}


	@Override
	public ApiResponse completeResetPasswordProcess(SignUpRequest signUpRequest) {
		ApiResponse response = new ApiResponse();
		Optional<User> userOptional = null;
		User user = null;
		try {

			userOptional = userRepository
					.findByUserEmailId((null != signUpRequest.getUserEmailId() ? signUpRequest.getUserEmailId().toLowerCase()
							: signUpRequest.getUserEmailId()));

			if (userOptional.isEmpty()) {
				return new ApiResponse(false, "The given Email is Invalid " + signUpRequest.getUserEmailId(),
						ErrorConstants.ERROR_CODE_401);
			}

			user = userOptional.get();

			if (!StringUtils.isBlank(signUpRequest.getPassword())) {
				user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
			} else {
				return new ApiResponse(false, "Password is Required", ErrorConstants.ERROR_CODE_401);
			}
			user = userRepository.saveAndFlush(user);

			try {
				commonUtils.sendEmail.accept(emailConfig.passwordResetSuccess.apply(user));
			} catch (Exception e) {
				log.debug("Could not send email to {} because of {} and the cause is{}", user.getUserEmailId(),
						e.getMessage(), e.getCause());
				response.setMessage(
						"Could not send email to " + user.getUserEmailId() + ". But password reset successfully.");
				response.setStatus(Boolean.TRUE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_200);
				return response;
			}
		} catch (Exception e) {
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setStatus(Boolean.FALSE);
			response.setStatusCode(ErrorConstants.ERROR_CODE_401);
			return response;
		}

		response.setMessage("User password updated successfully");
		response.setStatus(Boolean.TRUE);
		response.setStatusCode(ErrorConstants.ERROR_CODE_200);
		return response;
	}

	@Override
	public ApiResponse userlogin(@Valid LoginRequest login) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserProfile getUserProfile(@Valid SignUpRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ApiResponse updateUserProfile(@Valid SignUpRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ApiResponse approvalFlow(String usernameOrEmail) {
		if (null != usernameOrEmail) {
			usernameOrEmail = usernameOrEmail.toLowerCase();
		}

		Optional<User> userEntity = userRepository.findByUserEmailId(usernameOrEmail);
		if (!userEntity.isPresent()) {
			return ApiResponse.builder().status(Boolean.FALSE).message("Invalid Username.").statusCode("ERROR_CODE_401").build();
		}

		try {
			User user = userEntity.get();
//			if (!user.isRegistered()) {
//				return ApiResponse.builder().status(Boolean.FALSE).message("User not completed registration.").build();
//			}
			commonUtils.EmailRemainder.accept(user);
			commonUtils.sendEmail.accept(emailConfig.remainderEmail.apply(user));
			return ApiResponse.builder().status(Boolean.TRUE).message("Approval Mail Sent Successfully.").statusCode("ERROR_CODE_200").build();
		} catch (Exception e) {
			log.debug("Exception {} while sending mail for email id:" + usernameOrEmail,
					e.getMessage());
			return ApiResponse.builder().status(Boolean.FALSE)
					.message("Unable to sen mail. Please try again later.").statusCode("400").build();
		}
	}
}
	
	
	
