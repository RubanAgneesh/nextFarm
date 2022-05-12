package com.internaltools.service.impl;

import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.entity.Company;
import com.internaltools.persistence.repository.CompanyRepository;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.service.CompanyService;
import com.internaltools.util.ErrorConstants;
import com.stripe.model.issuing.Cardholder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

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

        try {
            if (null == request.getCompanyModel().getCompanyName()) {
                response.setMessage("Company Name is mandatory");
                response.setStatus(Boolean.FALSE);
                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
                return response;
            }
            Company company = new Company();
            company.setCompanyName(request.getCompanyModel().getCompanyName());

            companyRepository.save(company);
        }
        catch (Exception e){
            log.error("Exception in transferFromManualTransaction ::"+ e.getMessage());
            response.setStatus(false);
            response.setMessage("Failure");
            response.setStatusCode(ErrorConstants.ERROR_CODE_401);
            return response;
        }
        response.setStatus(true);
        response.setMessage("Success");
        response.setStatusCode(ErrorConstants.ERROR_CODE_401);
        return response;
    }
}
