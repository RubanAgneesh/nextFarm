package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceModel {
    private String invoiceId;

    private String company;

    private String date;

    private String invoiceNo;

    private String tax;

    private String bankDetails;

    private String billedTo;

    private String totalAmount;

    private String notes;

    private String mailedBy;

    private String poDetails;

    private CompanyModel companyModel;

}
