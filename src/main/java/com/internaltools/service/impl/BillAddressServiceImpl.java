package com.internaltools.service.impl;

import com.internaltools.payload.request.AddressRequest;
import com.internaltools.payload.request.BillAddressRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.entity.BillAddress;
import com.internaltools.persistence.repository.BillAddressRepository;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.service.BillAddressService;
import com.internaltools.util.ErrorConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Slf4j
@Service

public class BillAddressServiceImpl implements BillAddressService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillAddressRepository billAddressRepository;

    @Override
    public ApiResponse createBillAddress(@Valid BillAddressRequest request) {
        ApiResponse response = new ApiResponse();
        try {
            if (null == request.getBillAddressModel().getAddressLine1()){
                response.setMessage("Address is required");
                response.setStatus(Boolean.FALSE);
                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
                return response;
            }
            BillAddress ba = new BillAddress();

            ba.setAddressLine1(request.getBillAddressModel().getAddressLine1());

            ba.setAddressLine2(request.getBillAddressModel().getAddressLine2());

            ba.setCity(request.getBillAddressModel().getCity());

            ba.setCountry(request.getBillAddressModel().getCountry());

            ba.setState(request.getBillAddressModel().getState());

            ba.setZipCode(request.getBillAddressModel().getZipCode());

            billAddressRepository.save(ba);
        }
        catch(Exception e){
            log.error("Exception  ::" + e.getMessage());
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
