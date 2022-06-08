//package com.internaltools.service.impl;
//import com.internaltools.payload.request.CompanyRequest;
//import com.internaltools.payload.request.InvoiceRequest;
//import com.internaltools.payload.response.ApiResponse;
//import com.internaltools.payload.response.CompanyResponse;
//import com.internaltools.persistence.entity.Company;
//import com.internaltools.persistence.entity.Invoice;
//import com.internaltools.persistence.repository.CompanyRepository;
//import com.internaltools.persistence.repository.InvoiceRepository;
//import com.internaltools.service.InvoiceService;
//import com.internaltools.util.ErrorConstants;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Service
//
//public class InvoiceServiceImpl implements InvoiceService {
//    @Autowired
//    private  InvoiceRepository invoiceRepository;
//
//    @Autowired
//    private CompanyRequest companyRequest;
//
//    @Autowired
//    private CompanyRepository companyRepository;
//
//    @Override
//    public ApiResponse createInvoice(@Valid InvoiceRequest request) {
//        ApiResponse response = new ApiResponse();
////Invoice Post
//        try
//        {
//            if (null == request.getInvoiceModel().getInvoiceNo()) {
//                response.setMessage("Invoice No is mandatory");
//                response.setStatus(Boolean.FALSE);
//                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
//                return response;
//                }
//            Invoice invoice = new Invoice();
//            invoice.setInvoiceNo(request.getInvoiceModel().getInvoiceNo());
//
//            invoice.setTax(request.getInvoiceModel().getTax());
//
////            invoice.setBankDetails(request.getInvoiceModel().getBankDetails());
//
////            invoice.setBilledTo(request.getInvoiceModel().getBilledTo());
//
//            invoice.setTotalAmount(request.getInvoiceModel().getTotalAmount());
//
//            invoice.setNotes(request.getInvoiceModel().getNotes());
//
//            invoice.setMailedBy(request.getInvoiceModel().getMailedBy());
//
//            invoice.setPoDetails(request.getInvoiceModel().getPoDetails());
//
//            invoiceRepository.save(invoice);
//
//        }catch(Exception e) {
//            log.error("Exception in Invoice :: " + e.getMessage());
//            response.setStatus(false);
//            response.setMessage("Failure");
//            response.setStatusCode(ErrorConstants.ERROR_CODE_401);
//            return response;
//
//        }
//
//        response.setStatus(true);
//        response.setMessage("Success");
//        response.setStatusCode(ErrorConstants.ERROR_CODE_200);
//        return response;
//    }
//
//    @Override
//    public CompanyResponse getInvoiceList(@Valid CompanyRequest invoiceRequest) {
//        log.debug("****** Entering into InvoiceService :: getInvoiceList  ******");
//        CompanyResponse companyResponse = new CompanyResponse();
//
//        if (null == companyRequest || null == companyRequest.getCompanyId()) {
//            companyResponse.setMessage("Invalid Request. Invoice Id is required attribute.");
//            companyResponse.setStatus(Boolean.FALSE);
//            companyResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
//            return companyResponse;
//        }
//        Optional<Invoice>invoiceOptional = invoiceRepository.findById(companyRequest.getInvoiceId());
//        if (null == invoiceOptional || invoiceOptional.isEmpty()){
//            companyResponse.setMessage("Site is not available for given request.");
//            companyResponse.setStatus(Boolean.TRUE);
//            companyResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//            return companyResponse;
//        }
//        try{
//            Invoice invoice =  invoiceOptional.get();
//            List<Optional<Company>> companyListOpt = companyRepository
//                    .findByInvoiceIdAndCompanyNameContainigIgnoreCase(invoice.getInvoiceId(),
//                            companyRequest.getKeyword());
//
//
//
//
//
//            }catch (Exception e) {
//
//        }
//    }
//}
