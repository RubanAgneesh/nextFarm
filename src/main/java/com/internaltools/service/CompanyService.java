package com.internaltools.service;

import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;

import javax.validation.Valid;

/**
 * @author Ruban
 *
 */

public interface CompanyService {
    /**
     * @param request
     * @return
     */
    ApiResponse createCompany(@Valid CompanyRequest request);
}
