package com.internaltools.service;

import com.internaltools.payload.response.CountryResponse;



/**
 * @author jahir
 *
 */

public interface CountryService {


    /**
     * @param countryCode
     * @return CountryResponse
     */


    CountryResponse getByCountryCode (String countryCode);
}

