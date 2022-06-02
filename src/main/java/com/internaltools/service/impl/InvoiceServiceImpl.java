package com.internaltools.service.impl;
import com.internaltools.payload.request.InvoiceRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.entity.ClientMaster;
import com.internaltools.persistence.entity.Invoice;
import com.internaltools.persistence.repository.InvoiceRepository;
import com.internaltools.service.InvoiceService;
import com.internaltools.util.ErrorConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Slf4j
@Service

public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private  InvoiceRepository invoiceRepository;

    @Override
    public ApiResponse createInvoice(@Valid InvoiceRequest request) {
        ApiResponse response = new ApiResponse();

        try
        {
            if (null == request.getInvoiceModel().getInvoiceNo()) {
                response.setMessage("Invoice No is mandatory");
                response.setStatus(Boolean.FALSE);
                response.setStatusCode(ErrorConstants.ERROR_CODE_401);
                return response;
                }
            Invoice invoice = new Invoice();
            invoice.setInvoiceNo(request.getInvoiceModel().getInvoiceNo());

            invoice.setTax(request.getInvoiceModel().getTax());

//            invoice.setBankDetails(request.getInvoiceModel().getBankDetails());

//            invoice.setBilledTo(request.getInvoiceModel().getBilledTo());

            invoice.setTotalAmount(request.getInvoiceModel().getTotalAmount());

            invoice.setNotes(request.getInvoiceModel().getNotes());

            invoice.setMailedBy(request.getInvoiceModel().getMailedBy());

            invoice.setPoDetails(request.getInvoiceModel().getPoDetails());

            invoiceRepository.save(invoice);

        }catch(Exception e) {
            log.error("Exception in transferFromManualTransaction :: " + e.getMessage());
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
