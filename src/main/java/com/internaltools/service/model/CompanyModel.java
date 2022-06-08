package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CompanyModel {
	
	private  Long companyId;
	
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

}
