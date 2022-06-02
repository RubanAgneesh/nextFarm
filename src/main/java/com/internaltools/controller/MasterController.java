//package com.internaltools.controller;
//
//import com.internaltools.payload.request.CompanyRequest;
//import com.internaltools.payload.request.MasterRequest;
//import com.internaltools.payload.response.ApiResponse;
//import com.internaltools.service.MasterService;
//import io.swagger.annotations.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@Api
//@SwaggerDefinition(tags ={ @Tag(name="Master details" , description = "Master Details")})
//@RestController
//@RequestMapping("/api/master")
//@Slf4j
//
//public class MasterController {
//    @Autowired
//    private MasterService masterService;
//
//    @PostMapping("/createMaster")
//    @ApiOperation("Create Master")
//    public ApiResponse createMaster(@ApiParam(value = "The Request payload") @Valid @RequestBody MasterRequest request) {
//
//        return masterService.createMaster(request);
//    }
//}
