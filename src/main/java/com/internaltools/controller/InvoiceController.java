//package com.internaltools.controller;
//
//
//
//import com.internaltools.payload.request.CompanyRequest;
//import com.internaltools.payload.request.InvoiceRequest;
//import com.internaltools.payload.response.ApiResponse;
//import com.internaltools.payload.response.CompanyResponse;
//import com.internaltools.payload.response.InvoiceResponse;
//import com.internaltools.service.InvoiceService;
//import io.swagger.annotations.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@Api
//@SwaggerDefinition(tags ={ @Tag(name="Invoice details" , description = "Invoice Details")})
//@RestController
//@RequestMapping("/api/invoice")
//@Slf4j
//public class InvoiceController {
//    @Autowired
//    private InvoiceService invoiceService;
//
//    @PostMapping("/getInvoiceList")
////    @GetMapping("/getInvoiceById/{id}")
//    @ApiOperation("Create Invoice")
//
//
//    public ApiResponse createInvoice(@ApiParam(value = "The Request payload") @Valid @RequestBody InvoiceRequest request) {
//
//        return invoiceService.createInvoice(request);
//    }
//
////    @PostMapping("/getInvoiceList")
//    @ApiOperation(value = "getInvoiceList")
//    public CompanyResponse getInvoiceList (@ApiParam(value = "The Request payload")@Valid @RequestBody CompanyRequest companyRequest){
//        return invoiceService.getInvoiceList(companyRequest);
//    }
//}
