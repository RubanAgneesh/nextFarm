package com.internaltools.service;

import com.internaltools.payload.request.BillAddressRequest;
import com.internaltools.payload.response.ApiResponse;

/**
 * @author Ruban
 *
 */

public interface BillAddressService {
    /**
     * @param request
     * @return
     */
    ApiResponse createBillAddress(BillAddressRequest request);
}
