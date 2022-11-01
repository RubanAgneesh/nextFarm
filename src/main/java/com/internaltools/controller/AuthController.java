package com.internaltools.controller;

import javax.validation.Valid;

import com.internaltools.payload.request.SignUpRequest;
import com.internaltools.payload.response.*;
import com.internaltools.persistence.entity.User;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.service.model.UserCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internaltools.exception.AppException;
import com.internaltools.persistence.repository.ConfigPropertiesRepository;
import com.internaltools.security.JwtTokenProvider;
import com.internaltools.security.UserPrincipal;
import com.internaltools.service.RegistrationService;
import com.internaltools.service.TokenService;
import com.internaltools.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Api(tags = { "Authentication Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Authentication process", description = "Authentication process") })
@RestController
@RequestMapping("/api/signup")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private TokenService tokenservice;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfigPropertiesRepository configPropertiesRepository;


    @ApiOperation(value = "This service is used to validate the signup user", response = UserRegisterResponse.class)
    @PostMapping("/validateSignUpEmail")
    public ResponseEntity<UserRegisterResponse> validateSignUpEmail(@Valid @RequestBody com.internaltools.payload.request.SignUpRequest signUpRequest) throws JsonProcessingException {

        log.debug("****** Entering into registerUser *****");
        UserRegisterResponse registerResponse = null;
        log.debug("Request Object: {}", objectMapper.writeValueAsString(signUpRequest));
        try {
            registerResponse = registrationService.validateSignUpEmail(signUpRequest);
            if (null != registerResponse && registerResponse.getAlreadyRegistered()) {
                log.debug("registerUser :: registerResponse.getAlreadyRegistered() :: validateSignUpEmail :: If");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
            } else if (null != registerResponse) {
                log.debug("registerUser :: optional.isEmpty() else condition");
                return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
            }
        } catch (Exception e) {
            log.error("Exception in registerUser :: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
    }

    @ApiOperation(value = "This service is used to validate the signup user", response = UserRegisterResponse.class)
    @PostMapping("/sendSignUpOTP")
    public ResponseEntity<UserRegisterResponse> sendSignUpOTP(@Valid @RequestBody SignUpRequest signUpRequest) throws JsonProcessingException {

        log.debug("****** Entering into sendSignUpOTP *****");
        UserRegisterResponse registerResponse = null;
        log.debug("Request Object: {}", objectMapper.writeValueAsString(signUpRequest));
        try {
            registerResponse = registrationService.sendSignUpOTP(signUpRequest);
            if (null != registerResponse && registerResponse.getAlreadyRegistered()) {
                log.debug("sendSignUpOTP :: registerResponse.getAlreadyRegistered() :: validateSignUpEmail :: If");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
            } else if (null != registerResponse) {
                log.debug("sendSignUpOTP :: optional.isEmpty() else condition");
                return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
            }
        } catch (Exception e) {
            log.error("Exception in sendSignUpOTP :: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
    }


    @ApiOperation(value = "This service is used to validate the signup user", response = UserRegisterResponse.class)
    @PostMapping("/reSendSignUpOTP")
    public ResponseEntity<UserRegisterResponse> reSendSignUpOTP(@Valid @RequestBody com.internaltools.payload.request.SignUpRequest signUpRequest) throws JsonProcessingException {

        log.debug("****** Entering into reSendSignUpOTP *****");
        UserRegisterResponse registerResponse = null;
        log.debug("Request Object: {}", objectMapper.writeValueAsString(signUpRequest));
        try {
            registerResponse = registrationService.reSendSignUpOTP(signUpRequest);
            if (null != registerResponse && registerResponse.getStatus()) {
                log.debug("reSendSignUpOTP :: If ");
                return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
            } else if (null != registerResponse) {
                log.debug("reSendSignUpOTP :: Else ");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
            }
        } catch (Exception e) {
            log.error("Exception in reSendSignUpOTP :: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerResponse);
    }

    @ApiOperation(value = "Verify OTP for Registered mobile", response = ApiResponse.class)
    @PostMapping("/verifyOtp")
    public ResponseEntity<ApiResponse> verifyOtp(@Valid @RequestBody SignUpRequest signUpRequest) throws AppException, JsonProcessingException {

        log.debug("******Entering into verifyOtp ******");
        log.debug("Request Object: {}", objectMapper.writeValueAsString(signUpRequest));
        ApiResponse response = registrationService.verifyOtp(signUpRequest.getOtp(), signUpRequest.getUserEmailId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Complete registration process", response = ApiResponse.class)
    @PostMapping("/completeRegistration")
    public ResponseEntity<UserRegisterResponse> completeRegistration(@Valid @RequestBody SignUpRequest signUpRequest) throws JsonProcessingException {

        log.debug("******Entering into completeRegistration ******");
        UserRegisterResponse response = new UserRegisterResponse();
        log.debug("Request Object: {}", objectMapper.writeValueAsString(signUpRequest));
        response = registrationService.completeRegistrationProcess(signUpRequest);
        if (response.getStatus()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody SignUpRequest signUpRequest) throws JsonProcessingException {

        log.debug("****** Entering into authenticateUser *****");
        LoginResponse response = new LoginResponse();
        try {
            Optional<User> userOpt = userRepository.findByUserEmailId(signUpRequest.getUserEmailId().toLowerCase());
            User user = userOpt.get();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signUpRequest.getUserEmailId(), signUpRequest.getPassword()));
            UserCreateModel userCreateModel  = signUpRequest.getUserCreateModel();
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

            tokenservice.saveUserToken(
                    tokenservice.createUserToken(userPrincipal.getid().toString(), userPrincipal.getUserEmailId(), jwt));

            response = new LoginResponse(jwt);
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setUserId(user.getId());
            response.setUserEmailId(user.getUserEmailId());
            response.setMobileNumber(user.getMobileNumber());
            response.setStatus(true);
            response.setMessage("Login Successfully");
            response.setStatusCode("200");
        }   catch (Exception e) {
            response.setMessage("Enter valid Email and Password");
            response.setStatus(false);
            response.setStatusCode("400");
        }
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Forgot password OTP generation")
    @PostMapping("/sendResetPasswordOtp")
    public ResponseEntity<ApiResponse> forgotPassword(@RequestBody SignUpRequest signUpRequest) {

        if(null == signUpRequest || null == signUpRequest.getUserEmailId()) {
            return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
        }
        ApiResponse responseStatus = userService.sendResetPasswordOtp(signUpRequest.getUserEmailId());
        return new ResponseEntity<ApiResponse>(responseStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Verify Reset Password Otp")
    @PostMapping("/verifyResetPasswordOtp")
    public ResponseEntity<ApiResponse> verifyResetPasswordOtp(@RequestBody SignUpRequest signUpRequest) {

        if(null == signUpRequest || null == signUpRequest.getUserEmailId()) {
            return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
        }
        ApiResponse responseStatus = userService.verifyResetPasswordOtp(signUpRequest.getOtp(), signUpRequest.getUserEmailId());
        return new ResponseEntity<ApiResponse>(responseStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Complete Reset Password Process")
    @PostMapping("/completeResetPasswordProcess")
    public ResponseEntity<ApiResponse> completeResetPasswordProcess(@RequestBody SignUpRequest signUpRequest) {
        if(null == signUpRequest || null == signUpRequest.getUserEmailId()) {
            return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
        }
        ApiResponse responseStatus = userService.completeResetPasswordProcess(signUpRequest);
        return new ResponseEntity<ApiResponse>(responseStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Forgot password OTP generation")
    @PostMapping("/approvalFlowMail")
    public ResponseEntity<ApiResponse> approvalFlowMail(@RequestBody SignUpRequest signUpRequest) {

        if(null == signUpRequest || null == signUpRequest.getUserEmailId()) {
            return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
        }
        ApiResponse responseStatus = userService.approvalFlow(signUpRequest.getUserEmailId());
        return new ResponseEntity<ApiResponse>(responseStatus, HttpStatus.OK);
    }
}