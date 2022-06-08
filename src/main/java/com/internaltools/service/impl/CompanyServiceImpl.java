package com.internaltools.service.impl;

import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.CompanyResponse;
import com.internaltools.persistence.entity.Company;
import com.internaltools.persistence.repository.CompanyRepository;
import com.internaltools.persistence. repository.UserRepository;
import com.internaltools.service.CompanyService;
import com.internaltools.service.model.CompanyModel;
import com.internaltools.util.ErrorConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
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
            Company company = new Company();

            company.setCompanyName(request.getCompanyModel().getCompanyName());

            company.setCompanyCode("PIR" + rand_int1);

            company.setWebsite(request.getCompanyModel().getWebsite());

            company.setStartDate(request.getCompanyModel().getStartDate());

            company.setPanNumber(request.getCompanyModel().getPanNumber());

            company.setGstin(request.getCompanyModel().getGstin());

            company.setTelephoneNumber(request.getCompanyModel().getTelephoneNumber());

            company.setRegisterationNumber(request.getCompanyModel().getRegisterationNumber());

            company.setServices(request.getCompanyModel().getServices());

            company.setBankDetails(request.getCompanyModel().getBankDetails());

            company.setInvoicePrefix(request.getCompanyModel().getInvoicePrefix());

            company.setBankName(request.getCompanyModel().getBankName());

            company.setIfscCode(request.getCompanyModel().getIfscCode());

            company.setBranchName(request.getCompanyModel().getBranchName());

            company.setAccountHolderName(request.getCompanyModel().getAccountHolderName());

            company.setAccountNumber(request.getCompanyModel().getAccountNumber());

             company.setReenterAccountNumber(request.getCompanyModel().getReenterAccountNumber());

             company.setSwiftCode(request.getCompanyModel().getSwiftCode());

             company.setContactAddress1(request.getCompanyModel().getContactAddress1());

             company.setContactAddress2(request.getCompanyModel().getContactAddress2());

             company.setContactCountry(request.getCompanyModel().getContactCountry());

             company.setContactCity(request.getCompanyModel().getContactCity());

             company.setContactState(request.getCompanyModel().getContactState()); ;

             company.setContactZipCode(request.getCompanyModel().getContactZipCode());

             company.setContactName(request.getCompanyModel().getContactName());

             company.setContactDesignation(request.getCompanyModel().getContactDesignation());

             company.setContactEmailId(request.getCompanyModel().getContactEmailId());

             company.setContactPhoneNumber(request.getCompanyModel().getContactPhoneNumber());

             company.setCompanyAddress1(request.getCompanyModel().getCompanyAddress1());

             company.setCompanyAddress2(request.getCompanyModel().getCompanyAddress2());

             company.setCompanyCity(request.getCompanyModel().getCompanyCity());

             company.setCompanyCountry(request.getCompanyModel().getCompanyCountry());

             company.setCompanyState(request.getCompanyModel().getCompanyState());

             company.setCompanyZipCode(request.getCompanyModel().getCompanyZipCode());

             companyRepository.save(company);
        } catch (Exception e) {
            log.error("Exception in Company ::" + e.getMessage());
            response.setStatus(false);
            response.setMessage("Failure");
            response.setStatusCode(ErrorConstants.ERROR_CODE_401);
            return response;


        }
        response.setStatus(true);
        response.setMessage("Success");
        response.setStatusCode(ErrorConstants.ERROR_CODE_200);
        return response;

    }
    @Override
    public CompanyResponse getByCompanyId(Long companyId) {

        CompanyResponse response = new CompanyResponse();
        Optional<Company> companySelectedOpt = companyRepository.findById(companyId);


                CompanyModel companyModel = new CompanyModel();
                BeanUtils.copyProperties(companySelectedOpt.get(), companyModel);

    response.setCompanyModel(companyModel);
            response.setStatus(true);
            response.setMessage("Success");
            response.setStatusCode(ErrorConstants.ERROR_CODE_200);
            return response;
    }

}