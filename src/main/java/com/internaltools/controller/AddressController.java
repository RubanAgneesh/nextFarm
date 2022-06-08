package com.internaltools.controller;

import com.internaltools.payload.request.AddressRequest;
import com.internaltools.payload.request.BankRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.AddressService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api
@SwaggerDefinition(tags ={ @Tag(name="Address details" , description = "Address Details")})
@RestController
@RequestMapping("/api/address")
@Slf4j

public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping("/createAddress")
    @ApiOperation("create Address")

    public ApiResponse createAddress(@ApiParam(value = "The Request payload") @Valid @RequestBody AddressRequest request) {

        return addressService.createAddress(request);
    }

}
