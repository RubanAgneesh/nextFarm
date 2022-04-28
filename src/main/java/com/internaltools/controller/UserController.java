package com.internaltools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internaltools.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "User Controller" })
@SwaggerDefinition(tags = { @Tag(name = "User details", description = "User Details") })
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	ObjectMapper objectMapper;


	
	
}