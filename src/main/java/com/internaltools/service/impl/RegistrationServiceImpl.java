package com.internaltools.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.internaltools.service.model.UserCreateModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.internaltools.config.email.NextFarmEmailConfigurations;
import com.internaltools.exception.AppException;
import com.internaltools.payload.request.SignUpRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.UserRegisterResponse;
import com.internaltools.persistence.entity.User;
import com.internaltools.persistence.entity.UserRegistration;
import com.internaltools.persistence.repository.UserRegistrationRepository;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.security.JwtTokenProvider;
import com.internaltools.service.RegistrationService;
import com.internaltools.util.CommonUtils;
import com.internaltools.util.ErrorConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	PasswordEncoder passwordEncoder;


	@Autowired
	private NextFarmEmailConfigurations emailConfig;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommonUtils commonUtils;

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@Override
	public UserRegisterResponse validateSignUpEmail(@NotNull @Valid SignUpRequest signUpRequest) {

		UserRegisterResponse registerResponse = new UserRegisterResponse();
		log.debug("****** Entering into registerService :: validateSignUpEmail  ******");
		if (null == signUpRequest.getUserEmailId()) {
			registerResponse.setMessage("Please enter a valid email id.");
			registerResponse.setStatus(false);
			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
			return registerResponse;
		}
		Optional<User> userOpt = userRepository.findByUserEmailId(
				(null != signUpRequest.getUserEmailId() ? signUpRequest.getUserEmailId().toLowerCase()
						: signUpRequest.getUserEmailId()));
		if (!userOpt.isEmpty() && null != userOpt) {
			User userEntity = userOpt.get();
			if (userEntity.isRegistered()) {
				registerResponse.setAlreadyRegistered(true);
				registerResponse.setPartiallyRegistered(false);
				registerResponse.setExceedOtpCount(false);
				registerResponse.setMessage("Given email id already exists.");
				registerResponse.setStatus(true);
				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
			} else if (userEntity.getOtpCount() > 10) {
				registerResponse.setAlreadyRegistered(false);
				registerResponse.setPartiallyRegistered(true);
				registerResponse.setExceedOtpCount(true);
				registerResponse.setMessage("Please contact WeBucks support team for Activation.");
				registerResponse.setStatus(true);
				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
			}
			else if (null != userEntity.getUserEmailId() && !userEntity.getUserEmailId().isEmpty()) {
				registerResponse.setAlreadyRegistered(false);
				registerResponse.setPartiallyRegistered(true);
				registerResponse.setExceedOtpCount(false);
				registerResponse.setMessage(
						"Previous Registration is incomplete. Please complete the full process and login again");
				registerResponse.setStatus(true);
				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
			}
		} else {
			registerResponse.setAlreadyRegistered(false);
			registerResponse.setPartiallyRegistered(false);
			registerResponse.setExceedOtpCount(false);
			registerResponse.setMessage("Email Id is not registered yet");
			registerResponse.setStatus(false);
			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
		}
		return registerResponse;
	}

	@Override
	public UserRegisterResponse sendSignUpOTP(@Valid SignUpRequest signUpRequest) {

		UserRegisterResponse registerResponse = new UserRegisterResponse();
		Optional<User> usersOptional = userRepository.findByUserEmailId(
				(null != signUpRequest.getUserEmailId() ? signUpRequest.getUserEmailId().toLowerCase()
						: signUpRequest.getUserEmailId()));
		if (usersOptional.isEmpty()) {
			User user = User.builder().userEmailId(signUpRequest.getUserEmailId()).isActive(false).otpCount(1).build();

			user = userRepository.save(user);
			commonUtils.createVerificationOtp.accept(user);

			commonUtils.sendEmail.accept(emailConfig.signUpOtpEmail.apply(user));

			registerResponse.setAlreadyRegistered(false);
			registerResponse.setPartiallyRegistered(true);
			registerResponse.setExceedOtpCount(false);
			registerResponse.setMessage("OTP has been sent successfully");
			registerResponse.setStatus(true);
			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
		} else {

			User user = usersOptional.get();
			if (user.getOtpCount() > 10) {
				registerResponse.setAlreadyRegistered(false);
				registerResponse.setPartiallyRegistered(true);
				registerResponse.setExceedOtpCount(true);
				registerResponse.setMessage("Please contact WeBucks support team for Activation. ");
				registerResponse.setStatus(true);
				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
				return registerResponse;
			}

			Optional<UserRegistration> otpOptional = userRegistrationRepository.findByUserIdAndOtpValid(user.getId(),
					true);
			if (otpOptional.isPresent()) {
				log.debug("reSendSignUpOTP :: otpOptional.isPresent() :: " + user.getId());
				user.setOtp(otpOptional.get().getOtp());
			} else {
				commonUtils.createVerificationOtp.accept(user);
			}
			commonUtils.sendEmail.accept(emailConfig.signUpOtpEmail.apply(user));
			user.setOtpCount(user.getOtpCount() + 1);
			user = userRepository.save(user);

			registerResponse.setAlreadyRegistered(false);
			registerResponse.setPartiallyRegistered(true);
			registerResponse.setExceedOtpCount(false);
			registerResponse.setMessage("OTP has been sent successfully");
			registerResponse.setStatus(true);
			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
		}
		return registerResponse;
	}

	@Override
	public UserRegisterResponse reSendSignUpOTP(@Valid SignUpRequest signUpRequest) {

		UserRegisterResponse registerResponse = new UserRegisterResponse();
		Optional<User> usersOptional = userRepository.findByUserEmailId(
				(null != signUpRequest.getUserEmailId() ? signUpRequest.getUserEmailId().toLowerCase()
						: signUpRequest.getUserEmailId()));
		if (usersOptional.isEmpty()) {

			registerResponse.setAlreadyRegistered(false);
			registerResponse.setPartiallyRegistered(false);
			registerResponse.setExceedOtpCount(false);
			registerResponse.setMessage("User with email " + signUpRequest.getUserEmailId() + " does not exist.");
			registerResponse.setStatus(true);
			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
			return registerResponse;
		}
		User user = usersOptional.get();

		Optional<UserRegistration> otpOptional = userRegistrationRepository.findByUserIdAndOtpValid(user.getId(), true);
		if (otpOptional.isPresent()) {
			log.debug("reSendSignUpOTP :: otpOptional.isPresent() :: " + user.getId());
			UserRegistration otp = otpOptional.get();
			user.setOtp(otpOptional.get().getOtp());
			if (user.getOtpCount() > 10) {
				otp.setOtpValid(false);
				userRegistrationRepository.save(otp);
				registerResponse.setAlreadyRegistered(false);
				registerResponse.setPartiallyRegistered(true);
				registerResponse.setExceedOtpCount(true);
				registerResponse.setMessage("Please contact WeBucks support team for Activation. ");
				registerResponse.setStatus(true);
				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
				return registerResponse;
			}
		} else {
			registerResponse.setAlreadyRegistered(false);
			registerResponse.setPartiallyRegistered(true);
			registerResponse.setExceedOtpCount(true);
			registerResponse.setMessage("Please contact WeBucks support team for Activation. ");
			registerResponse.setStatus(true);
			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
			return registerResponse;
		}
		commonUtils.sendEmail.accept(emailConfig.signUpOtpEmail.apply(user));
		user.setOtpCount(user.getOtpCount() + 1);
		user = userRepository.save(user);

		registerResponse.setAlreadyRegistered(false);
		registerResponse.setPartiallyRegistered(true);
		registerResponse.setExceedOtpCount(false);
		registerResponse.setMessage("OTP has been sent successfully");
		registerResponse.setStatus(true);
		registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
		return registerResponse;
	}

	@Override
	public ApiResponse verifyOtp(@NotNull Integer token, String userEmailId) throws AppException {

		UserRegistration userRegistration = null;
		final Optional<UserRegistration> otp = userRegistrationRepository.findByOtpAndOtpValidAndUserUserEmailId(token,
				true, (null != userEmailId ? userEmailId.toLowerCase() : userEmailId));
		if (otp.isEmpty()) {
			return new ApiResponse(false, "Please enter the correct OTP ", ErrorConstants.ERROR_CODE_401);
		}

		User user = userRepository.findByUserEmailId(userEmailId).get();

		userRegistration = otp.get();
		if (user.getOtpCount() > 10) {
			userRegistration.setOtpValid(false);
			userRegistrationRepository.save(userRegistration);
			return new ApiResponse(true, "The Given OTP is Expired", ErrorConstants.ERROR_CODE_200);
		}
		if (userRegistration.isRegistered()) {
			return new ApiResponse(true, "Unable to Activate User. User is already activated",
					ErrorConstants.ERROR_CODE_200);
		} else {
			userRegistration.setOtpValid(true);
			userRegistrationRepository.save(userRegistration);
			return new ApiResponse(true, " Your email Id is successfully verified", ErrorConstants.ERROR_CODE_200);
		}
	}

	@Transactional
	public UserRegisterResponse completeRegistrationProcess(SignUpRequest signUpRequest) {

		UserRegisterResponse response = new UserRegisterResponse();
		Optional<User> userOptional = null;
		User user = null;
		try {
			userOptional = userRepository.findByUserEmailId(
					(null != signUpRequest.getUserEmailId() ? signUpRequest.getUserEmailId().toLowerCase()
							: signUpRequest.getUserEmailId()));
			if (userOptional.isEmpty()) {
				response.setStatus(false);
				response.setMessage("The given Email is Invalid" + signUpRequest.getUserEmailId());
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			user = userOptional.get();

			if (!StringUtils.isBlank(signUpRequest.getAadharNumber())) {
				user.setAadharNumber(signUpRequest.getAadharNumber());
			} else {
				response.setStatus(false);
				response.setMessage("First Name is Required");
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
			}
			user.setVoterId(signUpRequest.getVoterId());
			user.setAadharName(signUpRequest.getAadharName());
			user.setMobileNumber(signUpRequest.getMobileNumber());
			user.setGender(signUpRequest.getGender());
			user.setFatherName(signUpRequest.getFatherName());
			user.setCountry(signUpRequest.getCountry());
			user.setState(signUpRequest.getState());
			user.setDistrict(signUpRequest.getDistrict());
			user.setVillage(signUpRequest.getVillage());
			user.setPinCode(signUpRequest.getPinCode());
			user.setAssemblyConstituency(signUpRequest.getAssemblyConstituency());
			if (!StringUtils.isBlank(signUpRequest.getPassword())) {
				user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
				// +user.setPassword(signUpRequest.getPassword());

			} else {
				response.setStatus(false);
				response.setMessage("Password is Required");
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}

			if (!StringUtils.isBlank(signUpRequest.getMobileNumber())) {
				user.setMobileNumber(signUpRequest.getMobileNumber());
			}
			user.setImageKey(signUpRequest.getImageKey());

			user.setImagePath(signUpRequest.getImagePath());

			if (!StringUtils.isBlank(signUpRequest.getImageUrl())) {
				user.setImageUrl(signUpRequest.getImageUrl());
			}
			if (!StringUtils.isBlank(signUpRequest.getUserEmailId())) {
				user.setUserEmailId(signUpRequest.getUserEmailId());
			}

			else {
				// return new ApiResponse(false, "Email is Required",
				// ErrorConstants.ERROR_CODE_401);
				response.setStatus(false);
				response.setMessage("Email is Required");
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			user = userRepository.save(user);
			user.setActive(true);
			user.setRegistered(true);
			user = userRepository.save(user);
			response.setUserId(user.getId());
			try {
				//commonUtils.sendEmail.accept(emailConfig.welcomeEmail.apply(user));
			} catch (Exception e) {
//				log.debug("Could not send email to {} because of {} and the cause is{}", user.getUserEmailId(),
//						e.getMessage(), e.getCause());

				response.setMessage(user.getUserEmailId() + " user registered successfully.");

				// response.setMessage("Could not send email to " + user.getUserEmailId() + ".
				// But user registered successfully.");
				response.setMessage("User registered successfully.");
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
		response.setMessage("Your account is created successfully.");
		response.setStatus(Boolean.TRUE);
		response.setStatusCode(ErrorConstants.ERROR_CODE_200);
		return response;
	}
}
