package com.internaltools.controller;

import com.internaltools.payload.request.BankRequest;
import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.BankService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api
@SwaggerDefinition(tags ={ @Tag(name="Bank details" , description = "Bank Details")})
@RestController
@RequestMapping("/api/bank")
@Slf4j

public class BankController {
    @Autowired
    private BankService bankService;

    @PostMapping("/createBank")
    @ApiOperation("create Bank")

    public ApiResponse createBank(@ApiParam(value = "The Request payload") @Valid @RequestBody BankRequest request) {

        return bankService.createBank(request);
    }
}
