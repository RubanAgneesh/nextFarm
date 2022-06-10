package com.internaltools.service.impl;

import com.internaltools.payload.request.AddressRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.repository.AddressRepository;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.persistence.entity.Address;
import com.internaltools.service.AddressService;
import com.internaltools.util.ErrorConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Slf4j
@Service

public class AddressServiceImpl implements AddressService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public ApiResponse createAddress(@Valid AddressRequest request) {
        ApiResponse response = new ApiResponse();

        try {
            if (null == request.getAddressModel().getAddressLine1()) {
                response.setMessage("Required");
                response.setStatus(Boolean.FALSE);
                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
                return response;

            }
            Address adr = new Address();
            adr.setAddressLine1(request.getAddressModel().getAddressLine1());
            adr.setAddressLine2(request.getAddressModel().getAddressLine2());
            adr.setCounty(request.getAddressModel().getCounty());
            adr.setCity(request.getAddressModel().getCity());
            adr.setState(request.getAddressModel().getState());
            adr.setZipCode(request.getAddressModel().getZipCode());
            adr.setContactName(request.getAddressModel().getContactName());
            adr.setContactDesignation(request.getAddressModel().getContactDesignation());
            adr.setEmailId(request.getAddressModel().getEmailId());
            adr.setPhoneNumber(request.getAddressModel().getPhoneNumber());
            adr.setCountry(request.getAddressModel().getCounty());
//            adr.setIsBilling(request.getAddressModel().getIsBilling());
            addressRepository.save(adr);

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


