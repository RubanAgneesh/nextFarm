package com.internaltools.controller;

import com.internaltools.payload.request.BillAddressRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.BillAddressService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@SwaggerDefinition(tags ={ @Tag(name="BillAddress details" , description = "BillAddress Details")})
@RestController
@RequestMapping("/api/billaddress")
@Slf4j

public class BillAddressController {
    @Autowired
    private BillAddressService billAddressService;
    @PostMapping("/createBillAddress")
    @ApiOperation("create BillAddress")

    public ApiResponse createBillAddress(@ApiParam(value = "The Request payload") @RequestBody BillAddressRequest request) {

        return billAddressService.createBillAddress(request);
    }

}
