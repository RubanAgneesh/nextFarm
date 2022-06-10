package com.internaltools.service;

import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.request.InvoiceRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.CompanyResponse;

import javax.validation.Valid;

/**
 * @author Ruban
 *
 */
public interface InvoiceService {
//    /**
//     * @param request
//     * @return
//     */
//    ApiResponse createInvoice(@Valid InvoiceRequest request);
    /**
     * @param request
     * @return
     */
//    InvoiceResponse getInvoiceById(Long id);

//    CompanyResponse getCompanyId(Long id);

    ApiResponse createInvoice(@Valid InvoiceRequest request);

    /**
     * @param invoiceRequest
     * @return
     */
    CompanyResponse getInvoiceList(@Valid CompanyRequest invoiceRequest);
}
