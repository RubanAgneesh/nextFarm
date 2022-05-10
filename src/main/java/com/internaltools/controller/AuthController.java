package com.internaltools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "Authentication Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Authentication process", description = "Authentication process") })
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {


}