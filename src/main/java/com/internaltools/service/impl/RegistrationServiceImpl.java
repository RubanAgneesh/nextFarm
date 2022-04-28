package com.internaltools.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.internaltools.config.email.InternalToolsEmailConfigurations;
import com.internaltools.persistence.repository.UserRegistrationRepository;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.security.JwtTokenProvider;
import com.internaltools.service.RegistrationService;
import com.internaltools.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private InternalToolsEmailConfigurations emailConfig;

	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;
	
//	@Autowired
//	private LinkedEmailsRepository linkedEmailsRepository;
//
//	@Override
//	public UserRegisterResponse validateSignUpEmail(@NotNull @Valid UserSignUpRequest signUpRequest) {
//		
//		UserRegisterResponse registerResponse = new UserRegisterResponse();
//		log.debug("****** Entering into registerService :: validateSignUpEmail  ******");
//		if(null == signUpRequest.getEmail()) {
//			registerResponse.setMessage("Please enter a valid email id.");
//			registerResponse.setStatus(false);
//			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
//			return registerResponse;
//		}
//		Optional<User> userOpt = userRepository.findByEmail((null != signUpRequest.getEmail() ? 
//				signUpRequest.getEmail().toLowerCase() : signUpRequest.getEmail()));
//		if(!userOpt.isEmpty() && null != userOpt) {
//			User userEntity = userOpt.get();
//			if(userEntity.isRegistered()) {
//				registerResponse.setAlreadyRegistered(true);
//				registerResponse.setPartiallyRegistered(false);
//				registerResponse.setExceedOtpCount(false);
//				registerResponse.setMessage("Given email id already exists. Please login with this email id or try registering with a new email id.");
//				registerResponse.setStatus(true);
//				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//			} else if (userEntity.getOtpCount() > 10) {
//				registerResponse.setAlreadyRegistered(false);
//				registerResponse.setPartiallyRegistered(true);
//				registerResponse.setExceedOtpCount(true);
//				registerResponse.setMessage("Please contact Dockket support team for Activation.");
//				registerResponse.setStatus(true);
//				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//			} else if(null != userEntity.getEmail() && !userEntity.getEmail().isEmpty()) {
//				registerResponse.setAlreadyRegistered(false);
//				registerResponse.setPartiallyRegistered(true);
//				registerResponse.setExceedOtpCount(false);
//				registerResponse.setMessage("Previous Registration is incomplete. Please complete the full process and login again");
//				registerResponse.setStatus(true);
//				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//			} else {
//				registerResponse.setAlreadyRegistered(false);
//				registerResponse.setPartiallyRegistered(true);
//				registerResponse.setExceedOtpCount(false);
//				registerResponse.setMessage("Previous Registration is incomplete. Please complete the full process and login again");
//				registerResponse.setStatus(true);
//				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//			}
//		} else {
//			registerResponse.setAlreadyRegistered(false);
//			registerResponse.setPartiallyRegistered(false);
//			registerResponse.setExceedOtpCount(false);
//			registerResponse.setMessage("Email Id is not registered yet. Please Signup and Login again.");
//			registerResponse.setStatus(true);
//			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//		}
//		return registerResponse;
//	}
//
//	@Override
//	public UserRegisterResponse sendSignUpOTP(@Valid UserSignUpRequest signUpRequest) {
//		
//		UserRegisterResponse registerResponse = new UserRegisterResponse();
//		Optional<User> usersOptional = userRepository.findByEmail((null != signUpRequest.getEmail() ? 
//				signUpRequest.getEmail().toLowerCase() : signUpRequest.getEmail()));
//		if(usersOptional.isEmpty()) {
//			User user = User.builder()
//					.email(signUpRequest.getEmail())
//					.isActive(false)
//					.otpCount(1)
//					.build();
//			
//			user = userRepository.save(user);
//			commonUtils.createVerificationOtp.accept(user);
//			
//			commonUtils.sendEmail.accept(emailConfig.signUpOtpEmail.apply(user));
//			
//			registerResponse.setAlreadyRegistered(false);
//			registerResponse.setPartiallyRegistered(true);
//			registerResponse.setExceedOtpCount(false);
//			registerResponse.setMessage("OTP has been sent successfully");
//			registerResponse.setStatus(true);
//			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//		} else {
//			
//			User user = usersOptional.get();
//			if (user.getOtpCount() > 10) {
//				registerResponse.setAlreadyRegistered(false);
//				registerResponse.setPartiallyRegistered(true);
//				registerResponse.setExceedOtpCount(true);
//				registerResponse.setMessage("Please contact Dockket support team for Activation. ");
//				registerResponse.setStatus(true);
//				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//				return registerResponse;
//			}
//			
//			Optional<UserRegistration> otpOptional = userRegistrationRepository.findByUserIdAndOtpValid(user.getId(), true);
//			if (otpOptional.isPresent()) {
//				log.debug("reSendSignUpOTP :: otpOptional.isPresent() :: " + user.getId());
//				user.setOtp(otpOptional.get().getOtp());
//			} else {
//				commonUtils.createVerificationOtp.accept(user);
//			}
//			commonUtils.sendEmail.accept(emailConfig.signUpOtpEmail.apply(user));
//			user.setOtpCount(user.getOtpCount() + 1);
//			user = userRepository.save(user);
//			
//			registerResponse.setAlreadyRegistered(false);
//			registerResponse.setPartiallyRegistered(true);
//			registerResponse.setExceedOtpCount(false);
//			registerResponse.setMessage("OTP has been sent successfully");
//			registerResponse.setStatus(true);
//			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//		}
//		return registerResponse;
//	}
//
//	@Override
//	public UserRegisterResponse reSendSignUpOTP(@Valid UserSignUpRequest signUpRequest) {
//		
//		UserRegisterResponse registerResponse = new UserRegisterResponse();
//		Optional<User> usersOptional = userRepository.findByEmail((null != signUpRequest.getEmail() ? 
//				signUpRequest.getEmail().toLowerCase() : signUpRequest.getEmail()));
//		if(usersOptional.isEmpty()) {
//			
//			registerResponse.setAlreadyRegistered(false);
//			registerResponse.setPartiallyRegistered(false);
//			registerResponse.setExceedOtpCount(false);
//			registerResponse.setMessage("User with email " + signUpRequest.getEmail() + " does not exist.");
//			registerResponse.setStatus(true);
//			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//			return registerResponse;
//		}
//		User user = usersOptional.get();
//		
//		Optional<UserRegistration> otpOptional = userRegistrationRepository.findByUserIdAndOtpValid(user.getId(), true);
//		if (otpOptional.isPresent()) {
//			log.debug("reSendSignUpOTP :: otpOptional.isPresent() :: " + user.getId());
//			UserRegistration otp = otpOptional.get();
//			user.setOtp(otpOptional.get().getOtp());
//			if (user.getOtpCount() > 10) {
//				otp.setOtpValid(false);
//				userRegistrationRepository.save(otp);
//				registerResponse.setAlreadyRegistered(false);
//				registerResponse.setPartiallyRegistered(true);
//				registerResponse.setExceedOtpCount(true);
//				registerResponse.setMessage("Please contact Dockket support team for Activation. ");
//				registerResponse.setStatus(true);
//				registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//				return registerResponse;
//			}
//		} else {
//			registerResponse.setAlreadyRegistered(false);
//			registerResponse.setPartiallyRegistered(true);
//			registerResponse.setExceedOtpCount(true);
//			registerResponse.setMessage("Please contact Dockket support team for Activation. ");
//			registerResponse.setStatus(true);
//			registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//			return registerResponse;
//		}
//		commonUtils.sendEmail.accept(emailConfig.signUpOtpEmail.apply(user));
//		user.setOtpCount(user.getOtpCount() + 1);
//		user = userRepository.save(user);
//		
//		registerResponse.setAlreadyRegistered(false);
//		registerResponse.setPartiallyRegistered(true);
//		registerResponse.setExceedOtpCount(false);
//		registerResponse.setMessage("OTP has been sent successfully");
//		registerResponse.setStatus(true);
//		registerResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//		return registerResponse;
//	}
//	
//	@Override
//	public ApiResponse verifyOtp(@NotNull Integer token, String email) throws AppException {
//		
//		UserRegistration userRegistration = null;
//		final Optional<UserRegistration> otp = userRegistrationRepository.findByOtpAndOtpValidAndUserEmail(token, true, (null != email ? 
//				email.toLowerCase() : email));
//		if(otp.isEmpty()) {
//			return new ApiResponse(false, "Please enter the correct OTP sent to your email.", ErrorConstants.ERROR_CODE_401);
//		}
//
//		User user = userRepository.findByEmail(email).get();
//
//		userRegistration = otp.get();
//		if (user.getOtpCount() > 10) {
//			userRegistration.setOtpValid(false);
//			userRegistrationRepository.save(userRegistration);
//			return new ApiResponse(true, "The Given Otp is Expired", ErrorConstants.ERROR_CODE_200);
//		}
//		if (userRegistration.isRegistered()) {
//			return new ApiResponse(true, "Unable to Activate User. User is already activated", ErrorConstants.ERROR_CODE_200);
//		} else {
//			userRegistration.setOtpValid(true);
//			userRegistrationRepository.save(userRegistration);
//			return new ApiResponse(true, "You have successfully verified your email id", ErrorConstants.ERROR_CODE_200);
//		}
//	}
//	
//	@Transactional
//	public ApiResponse completeRegistrationProcess(UserSignUpRequest signUpRequest) {
//
//		ApiResponse response = new ApiResponse();
//		Optional<User> userOptional = null;
//		User user = null;
//		try {
//			userOptional = userRepository.findByEmail((null != signUpRequest.getEmail() ? 
//					signUpRequest.getEmail().toLowerCase() : signUpRequest.getEmail()));
//			if(userOptional.isEmpty()) {
//				return new ApiResponse(false, "The given Email is Invalid " + signUpRequest.getEmail(), ErrorConstants.ERROR_CODE_401);
//			}
//			
//			user = userOptional.get();
//			
//			if (!StringUtils.isBlank(signUpRequest.getTitle())) {
//				user.setTitle(signUpRequest.getTitle());
//			}
//			
//			if (!StringUtils.isBlank(signUpRequest.getFirstName())) {
//				user.setFirstName(signUpRequest.getFirstName());
//			} else {
//				return new ApiResponse(false, "First Name is Required", ErrorConstants.ERROR_CODE_401);
//			}
//
//			if (!StringUtils.isBlank(signUpRequest.getLastName())) {
//				user.setLastName(signUpRequest.getLastName());
//			} else {
//				return new ApiResponse(false, "Last Name is Required", ErrorConstants.ERROR_CODE_401);
//			}
//			
//			if (!StringUtils.isBlank(signUpRequest.getPassword())) {
//				user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
//			} else {
//				return new ApiResponse(false, "Password is Required", ErrorConstants.ERROR_CODE_401);
//			}
//			
//			if (!StringUtils.isBlank(signUpRequest.getCountryCode())) {
//				user.setCountryCode(signUpRequest.getCountryCode());
//			}
//			
//			if (!StringUtils.isBlank(signUpRequest.getMobileNumber())) {
//				user.setMobileNumber(signUpRequest.getMobileNumber());
//			}
//
//			if (!StringUtils.isBlank(signUpRequest.getImageUrl())) {
//				user.setImageUrl(signUpRequest.getImageUrl());
//			}
//			
//			if (!StringUtils.isBlank(signUpRequest.getCountry())) {
//				user.setCountry(signUpRequest.getCountry());
//			}
//			
//			if (!StringUtils.isBlank(signUpRequest.getTimeZone())) {
//				user.setTimeZone(signUpRequest.getTimeZone());
//			}
//			
//			if (!StringUtils.isBlank(signUpRequest.getImageKey())) {
//				user.setImageKey(signUpRequest.getImageKey());
//			}
//			
//			if (!StringUtils.isBlank(signUpRequest.getEmail())) {
//				user.setUsername(signUpRequest.getEmail());
//			} else {
//				return new ApiResponse(false, "Email is Required", ErrorConstants.ERROR_CODE_401);
//			}
//			
//			user.setActive(true);
//			user.setNotificationToken(true);
//			user.setProviderType(SocialProvider.LOCAL.getProviderType());
//			user.setRegistered(true);
//			user = userRepository.saveAndFlush(user);
//			
//			try {
//				commonUtils.sendEmail.accept(emailConfig.welcomeEmail.apply(user));
//			} catch (Exception e) {
//				log.debug("Could not send email to {} because of {} and the cause is{}", user.getEmail(), e.getMessage(), e.getCause());
//				response.setMessage("Could not send email to " + user.getEmail() + ". But user registered successfully.");
//				response.setStatus(Boolean.TRUE);
//				response.setStatusCode(ErrorConstants.ERROR_CODE_200);
//				return response;
//			}
//		} catch (Exception e) {
//			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR);
//			response.setStatus(Boolean.FALSE);
//			response.setStatusCode(ErrorConstants.ERROR_CODE_401);
//			return response;
//		}
//
//		response.setMessage("Your Dockket account is created successfully.");
//		response.setStatus(Boolean.TRUE);
//		response.setStatusCode(ErrorConstants.ERROR_CODE_200);
//		return response;
//	}

}
