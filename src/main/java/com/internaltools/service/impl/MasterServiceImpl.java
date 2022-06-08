//package com.internaltools.service.impl;
//
//import com.internaltools.payload.request.CompanyRequest;
//import com.internaltools.payload.request.InvoiceRequest;
//import com.internaltools.payload.response.CompanyResponse;
//import com.internaltools.payload.response.InvoiceResponse;
//import com.internaltools.persistence.entity.Company;
//import com.internaltools.persistence.entity.Invoice;
//import com.internaltools.persistence.repository.CompanyRepository;
//import com.internaltools.persistence.repository.InvoiceRepository;
//import com.internaltools.service.InvoiceService;
//import com.internaltools.service.model.InvoiceModel;
//import com.internaltools.util.ErrorConstants;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
////package com.internaltools.service.impl;
////
////import com.internaltools.payload.request.ClientMasterRequest;
////import com.internaltools.payload.request.CompanyRequest;
////import com.internaltools.payload.request.InvoiceRequest;
////import com.internaltools.payload.request.MasterRequest;
////import com.internaltools.payload.response.ApiResponse;
////import com.internaltools.payload.response.CompanyResponse;
////import com.internaltools.payload.response.InvoiceResponse;
////import com.internaltools.persistence.entity.ClientMaster;
////import com.internaltools.persistence.entity.Company;
////import com.internaltools.persistence.entity.Invoice;
////import com.internaltools.persistence.repository.ClientMasterRepository;
////import com.internaltools.persistence.repository.CompanyRepository;
////import com.internaltools.persistence.repository.InvoiceRepository;
////import com.internaltools.service.MasterService;
////import com.internaltools.service.model.InvoiceModel;
////import com.internaltools.util.ErrorConstants;
////import lombok.extern.slf4j.Slf4j;
////import org.springframework.beans.BeanUtils;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import javax.validation.Valid;
////import java.util.ArrayList;
////import java.util.List;
////import java.util.Optional;
////import java.util.Random;
////
//@Slf4j
//@Service
////
////public class MasterServiceImpl implements MasterService{
////    @Autowired
////    private CompanyRepository companyRepository;
////
////    @Autowired
////    private ClientMasterRepository clientMasterRepository;
//////Company
////
////    public ApiResponse createCompany(@Valid CompanyRequest request) {
////        ApiResponse response = new ApiResponse();
////
////        Random rnd = new Random();
////        int rand_int1 = rnd.nextInt(1000);
////
////        try {
////            if (null == request.getCompanyModel().getCompanyName()) {
////                response.setMessage("Company name is required");
////                response.setStatus(Boolean.FALSE);
////                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
////                return response;
////            }
//////            else if (null == request.getCompanyModel().getCompanyCode()) {
//////                response.setMessage("Company Code is mandatory");
//////                Random rnd = new Random();
//////                int number = rnd.nextInt(999);
//////                response.setStatus(Boolean.FALSE);
//////                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
//////               return String.format("%06d", number);
//////
//////                return response;
//////            }
////            Company company = new Company();
////
////            company.setCompanyName(request.getCompanyModel().getCompanyName());
////
//////            company.setCompanyCode("PIR"+ Math.random());
//////            company.setCompanyCode("PIR"+ Math.random()*(max-min+1)+min);
////            company.setCompanyCode("PIR"+rand_int1);
//////                return ("PIR"+ Math.random());
//////                ("PIR"+ Math.random());
////
////            company.setWebsite(request.getCompanyModel().getWebsite());
////
////            company.setStartDate(request.getCompanyModel().getStartDate());
////
////            company.setPanNumber(request.getCompanyModel().getPanNumber());
////
////            company.setGstin(request.getCompanyModel().getGstin());
////
////            company.setTelephoneNumber(request.getCompanyModel().getTelephoneNumber());
////
////            company.setRegisterationNumber(request.getCompanyModel().getRegisterationNumber());
////
////            company.setServices(request.getCompanyModel().getServices());
////
////            company.setBankDetails(request.getCompanyModel().getBankDetails());
////
////            company.setAddressDetails(request.getCompanyModel().getAddressDetails());
////
////            company.setContactAddressDetails(request.getCompanyModel().getContactAddressDetails());
////
////            company.setInvoicePrefix(request.getCompanyModel().getInvoicePrefix());
////            companyRepository.save(company);
////        }
////
////
////
////        catch (Exception e){
////            log.error("Exception in transferFromManualTransaction ::"+ e.getMessage());
////            response.setStatus(false);
////            response.setMessage("Failure");
////            response.setStatusCode(ErrorConstants.ERROR_CODE_401);
////            return response;
////
////
////
////        }
////        response.setStatus(true);
////        response.setMessage("Success");
////        response.setStatusCode(ErrorConstants.ERROR_CODE_200);
////        return response;
////
////    }
////
////   //Client
////   public ApiResponse createClientMaster(@Valid ClientMasterRequest request) {
////       ApiResponse response = new ApiResponse();
////
////
////       try
////       {
////           if (null == request.getClientMasterModel().getClientName()) {
////               response.setMessage("Client Name is mandatory");
////               response.setStatus(Boolean.FALSE);
////               response.setStatusCode(ErrorConstants.ERROR_CODE_401);
////               return response;
////           }
////           ClientMaster clientMaster = new ClientMaster();
////           clientMaster.setClientName(request.getClientMasterModel().getClientName());
////
////           clientMasterRepository.save(clientMaster);
////       }
////       catch(Exception e) {
////           log.error("Exception in transferFromManualTransaction :: " + e.getMessage());
////           response.setStatus(false);
////           response.setMessage("Failure");
////           response.setStatusCode(ErrorConstants.ERROR_CODE_401);
////           return response;
////
////       }
////
////       response.setStatus(true);
////       response.setMessage("Success");
////       response.setStatusCode(ErrorConstants.ERROR_CODE_200);
////       return response;
////
////   }
////
////
////
////}
//public class MasterServiceImpl implements InvoiceService{
////    @Autowired
////    private  InvoiceRepository invoiceRepository;
////
////    @Override
////    public ApiResponse createInvoice(@Valid InvoiceRequest request) {
////        ApiResponse response = new ApiResponse();
//
//
//    @Autowired
//    private InvoiceRepository invoiceRepository;
//
//    @Autowired
//    private InvoiceResponse invoiceResponse;
//
//    @Autowired
//    private InvoiceRequest invoiceRequest;
//
//    @Autowired
//    private CompanyRequest companyRequest;
//
//    @Autowired
//    private CompanyRepository companyRepository;
//
//    @Autowired
//    private CompanyResponse companyResponse;
//
//    //    @Override
////    public InvoiceResponse createInvoice(@Valid InvoiceRequest request) {
////    InvoiceResponse response = new InvoiceResponse();
//    public InvoiceResponse getCompanyList(@Valid InvoiceRequest invoiceRequest) {
//        log.debug("****** Entering into InvoiceService :: getCompanyList  ******");
//        InvoiceResponse invoiceResponse = new InvoiceResponse();
//
//        if (null == invoiceRequest || null == invoiceRequest.getCompanyById) {
//            invoiceResponse.setMessage("Invalid Request. Company Id is required attribute.");
//            invoiceResponse.setStatus(Boolean.FALSE);
//            invoiceResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
//            return invoiceResponse;
//        }
//
//        Optional<Company> companyOptional = companyRepository.findById(invoiceRequest.getCompanyById());
//        if (null == companyOptional || companyOptional.isEmpty()) {
//            invoiceResponse.setMessage("Site is not available for given request.");
//            invoiceResponse.setStatus(Boolean.TRUE);
//            invoiceResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
//            return invoiceResponse;
//            try {
//                Company company = companyOptional.get();
//                List<Optional<Invoice>> invoiceOpt = invoiceRepository
//                        .findByCompanyIdAndInvoiceNameContainingIgnoreCase(company.getCompanyId(),
//                                invoiceRequest.getKeyword());
//                if (invoiceOpt.isEmpty()) {
//                    invoiceResponse.setMessage("Invoice Doesn't Exist for this Company.");
//                    invoiceResponse.setStatus(Boolean.FALSE);
//                    invoiceResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
//                    return invoiceResponse;
//                }
//                Invoice invoice = null;
//                List<InvoiceModel> invoiceModelList = new ArrayList<>();
//                for (Optional<Invoice> invoiceOptional : invoiceOpt) {
//                    InvoiceModel model = new InvoiceModel();
//                    invoice = invoice.get();
//                    BeanUtils.copyProperties(invoice, model);
//                }
//            } catch (Exception e) {
//                invoiceResponse.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR);
//                invoiceResponse.setStatus(Boolean.FALSE);
//                invoiceResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
//                return invoiceResponse;
//            }
//        }
//    }
//}
//
