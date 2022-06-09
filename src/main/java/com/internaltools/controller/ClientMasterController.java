package com.internaltools.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internaltools.payload.request.ClientMasterRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.ClientMasterService;
import com.internaltools.service.model.ClientMasterModel;
import com.internaltools.service.model.CompanyModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "ClientMaster Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Client details", description = "Client Details") })
@RestController
@RequestMapping("/api/client")
@Slf4j
public class ClientMasterController {
	@Autowired
	private ClientMasterService clientMasterService;
	
	@PostMapping("/createClient")
	@ApiOperation("Create Client")
	public ApiResponse createClientMaster(@ApiParam(value = "The Request payload") @Valid @RequestBody ClientMasterRequest request) {
	
		return clientMasterService.createClientMaster(request);
	}
	@GetMapping("/clients")
	@ApiOperation("View Client")
	public List<ClientMasterModel> getClients() {
		
		return clientMasterService.getClientList();
	}

}
