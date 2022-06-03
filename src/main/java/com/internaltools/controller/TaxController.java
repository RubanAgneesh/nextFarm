package com.internaltools.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internaltools.payload.request.TaxRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.TaxResponse;
import com.internaltools.service.TaxService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Tax Controller"})
@SwaggerDefinition(tags ={@Tag(name = "Tax Details", description = "Tax Details")})
@RestController
@RequestMapping("/api/tax")
@Slf4j
public class TaxController {
    @Autowired
    private TaxService taxService;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/createTax")
    @ApiOperation("Create Tax")

    public ApiResponse createTax(@ApiParam(value = "The Request payload") @Valid @RequestBody TaxRequest request) {

        return taxService.createTax(request);
    }

    @GetMapping("/getByTaxId/{taxId}")
    @ApiOperation(value = "getByTaxId")

    public TaxResponse getByTaxId(@PathVariable Long taxId) {
        return taxService.getByTaxId(taxId);

    }
}
