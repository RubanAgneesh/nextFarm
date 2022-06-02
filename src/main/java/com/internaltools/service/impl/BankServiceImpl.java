package com.internaltools.service.impl;

import com.internaltools.payload.request.BankRequest;
import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.entity.BankEntity;
import com.internaltools.persistence.repository.BankRepository;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.service.BankService;
import com.internaltools.util.ErrorConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Slf4j
@Service

public class BankServiceImpl implements BankService {
   @Autowired
    private UserRepository userRepository;

    @Autowired
    private BankRepository bankRepository;

    @Override
    public ApiResponse createBank(@Valid BankRequest request) {
        ApiResponse response = new ApiResponse();

        try {
            if (null == request.getBankModel().getBankName()){
                response.setMessage("Bank name is required");
                response.setStatus(Boolean.FALSE);
                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
                return response;


            }
            BankEntity bank1 = new BankEntity();
            bank1.setBankName(request.getBankModel().getBankName());

            bank1.setIfscCode(request.getBankModel().getIfscCode());

            bank1.setBranchName(request.getBankModel().getBranchName());

            bank1.setAccountHolderName(request.getBankModel().getAccountHolderName());

            bank1.setAccountNumber(request.getBankModel().getAccountNumber());

            bank1.setReenterAccountNumber(request.getBankModel().getReenterAccountNumber());

            bank1.setSwiftCode(request.getBankModel().getSwiftCode());

            bankRepository.save(bank1);
        }catch (Exception e){
            log.error("Exception  ::"+ e.getMessage());
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
}
