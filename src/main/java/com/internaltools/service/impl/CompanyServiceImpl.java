package com.internaltools.service.impl;

import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.entity.Company;
import com.internaltools.persistence.repository.CompanyRepository;
import com.internaltools.persistence. repository.UserRepository;
import com.internaltools.service.CompanyService;
import com.internaltools.util.ErrorConstants;
import com.stripe.model.issuing.Cardholder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Random;

@Slf4j
@Service

public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ApiResponse createCompany(@Valid CompanyRequest request) {
        ApiResponse response = new ApiResponse();

        Random rnd = new Random();
        int rand_int1 = rnd.nextInt(1000);

        try {
            if (null == request.getCompanyModel().getCompanyName()) {
                response.setMessage("Company name is required");
                response.setStatus(Boolean.FALSE);
                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
                return response;
            }
//            else if (null == request.getCompanyModel().getCompanyCode()) {
//                response.setMessage("Company Code is mandatory");
////                Random rnd = new Random();
////                int number = rnd.nextInt(999);
//                response.setStatus(Boolean.FALSE);
//                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
////               return String.format("%06d", number);
//
//                return response;
//            }
            Company company = new Company();

            company.setCompanyName(request.getCompanyModel().getCompanyName());

//            company.setCompanyCode("PIR"+ Math.random());
//            company.setCompanyCode("PIR"+ Math.random()*(max-min+1)+min);
              company.setCompanyCode("PIR"+rand_int1);
//                return ("PIR"+ Math.random());
//                ("PIR"+ Math.random());

            company.setWebsite(request.getCompanyModel().getWebsite());

            company.setStartDate(request.getCompanyModel().getStartDate());

            company.setPanNumber(request.getCompanyModel().getPanNumber());

            company.setGstin(request.getCompanyModel().getGstin());

            company.setTelephoneNumber(request.getCompanyModel().getTelephoneNumber());

            company.setRegisterationNumber(request.getCompanyModel().getRegisterationNumber());

            company.setServices(request.getCompanyModel().getServices());

            company.setBankDetails(request.getCompanyModel().getBankDetails());

            company.setAddressDetails(request.getCompanyModel().getAddressDetails());

            company.setContactAddressDetails(request.getCompanyModel().getContactAddressDetails());

            company.setInvoicePrefix(request.getCompanyModel().getInvoicePrefix());



           companyRepository.save(company);
           //Company Code




       }



        catch (Exception e){
            log.error("Exception in transferFromManualTransaction ::"+ e.getMessage());
            response.setStatus(false);
            response.setMessage("Failure");
            response.setStatusCode(ErrorConstants.ERROR_CODE_401);
            return response;


//
        }
        response.setStatus(true);
        response.setMessage("Success");
        response.setStatusCode(ErrorConstants.ERROR_CODE_200);
        return response;

    }
}
