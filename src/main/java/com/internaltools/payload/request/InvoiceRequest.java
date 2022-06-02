package com.internaltools.payload.request;

import com.internaltools.service.model.BankModel;
import com.internaltools.service.model.CompanyModel;
import com.internaltools.service.model.InvoiceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InvoiceRequest {
//    private getCompanyById getCompanyById;
//    private CompanyModel companyModel;
//
//    private List<CompanyModel> companyModelList;
//
//    private long companyId;


    private InvoiceModel invoiceModel;
    }

