package com.internaltools.service;

import com.internaltools.payload.request.BankRequest;
import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;

import javax.validation.Valid;

/**
 * @author Ruban
 *
 */

public interface BankService {
    /**
     * @param request
     * @return
     */
    ApiResponse createBank(@Valid BankRequest request);
}
