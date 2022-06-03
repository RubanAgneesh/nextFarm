package com.internaltools.service;

import com.internaltools.payload.request.TaxRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.TaxResponse;

import javax.validation.Valid;

/**
 * @author jahir
 *
 */

public interface TaxService {
    /**
     * @param request
     * @return
     */

    ApiResponse createTax(@Valid TaxRequest request);

    /**
     *
     * @param taxId
     * @return
     */
    TaxResponse getByTaxId(Long taxId);
}
