package com.internaltools.controller;

import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.service.CompanyService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api
@SwaggerDefinition(tags ={ @Tag(name="Company details" , description = "Company Details")})
@RestController
@RequestMapping("/api/company")
@Slf4j

public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/createCompany")
    @ApiOperation("Create Company")


        public ApiResponse createCompany(@ApiParam(value = "The Request payload") @Valid @RequestBody CompanyRequest request) {

            return companyService.createCompany(request);
    }
}
