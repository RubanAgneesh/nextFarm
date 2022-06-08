package com.internaltools.service;


import com.internaltools.payload.request.AddressRequest;
import com.internaltools.payload.response.ApiResponse;

import javax.validation.Valid;

/**
 * @author Ruban
 *
 */
public interface AddressService {
    /**
     * @param request
     * @return
     */
    ApiResponse createAddress(@Valid AddressRequest request);
}
