package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CompanyModel {
    private String companyName;

    private String companyCode;

    private String website;

    private String startDate;

    private String panNumber;

    private String gstin;

    private String telephoneNumber;

    private String registerationNumber;

    private String services;

    private String bankDetails;

    private String addressDetails;

    private String contactAddressDetails;

    private String invoicePrefix;
    //Bank Details
    private String bankName;

    private String ifscCode;

    private String branchName;

    private String accountHolderName;

    private String accountNumber;

    private String reenterAccountNumber;

    private String swiftCode;

    //Address
    private  String companyAddress1;

    private String companyAddress2;

    private  String companyCountry;

    private String companyCity;

    private String companyState;

    private String companyZipCode;

    private Boolean isBilling;

    //Contact Address Details
    private String contactAddress1;

    private String contactAddress2;

    private String contactCountry;

    private String contactCity;

    private String contactState;

    private String contactZipCode;

    private Boolean primaryAddress;

    private String contactName;

    private String contactDesignation;

    private String contactEmailId;

    private String contactPhoneNumber;
}
