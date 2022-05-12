package com.internaltools.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internaltools.payload.request.ClientMasterRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.ClientMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "ClientMaster Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Client details", description = "Client Details") })
@RestController
@RequestMapping("/api/clientmaster")
@Slf4j
public class ClientMasterController {
	@Autowired
	private ClientMasterService clientMasterService;
	
	@PostMapping("/createClientMaster")
	@ApiOperation("Create ClientMaster")
	public ApiResponse createClientMaster(@ApiParam(value = "The Request payload") @Valid @RequestBody ClientMasterRequest request) {
	
		return clientMasterService.createClientMaster(request);
	}

}
