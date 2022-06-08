package com.internaltools.service.impl;


import com.internaltools.payload.response.CountryResponse;
import com.internaltools.persistence.entity.Country;
import com.internaltools.persistence.repository.CountryRepository;
import com.internaltools.service.CountryService;
import com.internaltools.service.model.CountryModel;

import com.internaltools.util.ErrorConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryResponse getByCountryCode(String countryCode) {

            CountryResponse response = new CountryResponse();
            List<Country> countrySelectedOpt = countryRepository.findByCountryCode(countryCode);
            List<CountryModel> countryModelList = new ArrayList<>();
            if (!countrySelectedOpt.isEmpty()) {
                for (Country getCountry : countrySelectedOpt) {
                    CountryModel countryModel = new CountryModel();
                    BeanUtils.copyProperties(getCountry, countryModel);
                    countryModelList.add(countryModel);
                }

                response.setCountryModelList(countryModelList);
                response.setStatus(true);
                response.setMessage("Success");
                response.setStatusCode(ErrorConstants.ERROR_CODE_200);
                return response;
            } else {
                response.setMessage("Country Code or Country Name is missing");
                response.setStatus(Boolean.FALSE);
                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
            }
            return response;
    }
}
