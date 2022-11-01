package com.internaltools.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internaltools.payload.request.UserCreateRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = { "User Controller" })
@SwaggerDefinition(tags = { @Tag(name = "User details", description = "User Details") })
@RestController
@RequestMapping("/api/user")

public class UserController {

	@Autowired
	private UserService userService;
	

	@PostMapping("/createUser")
	@ApiOperation("Create User")
	public ApiResponse createUser(@ApiParam(value = "The Request payload") @Valid @RequestBody UserCreateRequest request) {
	
		return userService.createUser(request);
	}

	
	
}


