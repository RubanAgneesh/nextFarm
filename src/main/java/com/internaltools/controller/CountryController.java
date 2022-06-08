package com.internaltools.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.internaltools.payload.response.CountryResponse;
import com.internaltools.service.CountryService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Api(tags={"Country Controller"})
@SwaggerDefinition(tags = { @Tag(name="Country details", description = "Country Details")})
@RestController
@RequestMapping("/api/country")
@Slf4j

public class CountryController {
    @Autowired
    private CountryService countryService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/getByCountryCode/{countryCode}")
    @ApiOperation(value = "getByCountryCode")
    public CountryResponse getByCountryCode(@PathVariable String countryCode){
        return countryService.getByCountryCode(countryCode);


    }

}
