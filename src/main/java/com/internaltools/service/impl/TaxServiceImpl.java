package com.internaltools.service.impl;

import com.internaltools.payload.request.TaxRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.TaxResponse;
import com.internaltools.persistence.entity.Tax;
import com.internaltools.persistence.repository.TaxRepository;
import com.internaltools.persistence.repository.UserRepository;
import com.internaltools.service.TaxService;
import com.internaltools.service.model.TaxModel;
import com.internaltools.util.ErrorConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service

public class TaxServiceImpl implements TaxService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaxRepository taxRepository;

    @Override
    public ApiResponse createTax(@Valid TaxRequest request) {
        ApiResponse response = new ApiResponse();

        try {
            if(request.getTaxModel().getTaxType() == null){
                response.setMessage("Tax Type is mandatory");
                response.setStatus(Boolean.FALSE);
                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
                return response;
            }
            Tax tax = new Tax();
            tax.setTaxType(request.getTaxModel().getTaxType());
            tax.setTaxPercentage(request.getTaxModel().getTaxPercentage());
            tax.setTaxStatus(request.getTaxModel().getTaxStatus());

            taxRepository.save(tax);
        }
        catch (Exception e) {
            log.error("Exception in transferFromManualTransaction ::"+ e.getMessage());
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
    public TaxResponse getByTaxId(Long taxId) {

        TaxResponse response = new TaxResponse();
        List<Tax> taxSelectedOpt = taxRepository.findByTaxId(taxId);
        List<TaxModel> taxModelList = new ArrayList<>();
        if(!taxSelectedOpt.isEmpty()) {
            for (Tax getTax : taxSelectedOpt) {
                TaxModel taxModel = new TaxModel();
                BeanUtils.copyProperties(getTax, taxModel);
                taxModelList.add(taxModel);
            }
            response.setTaxModelList(taxModelList);
            response.setStatus(true);
            response.setMessage("Success");
            response.setStatusCode(ErrorConstants.ERROR_CODE_200);
            return response;
        } else {
            response.setMessage("TaxId is missing");
            response.setStatus(Boolean.FALSE);
            response.setStatusCode(ErrorConstants.ERROR_CODE_401);
        }

        return response;
    }

}
