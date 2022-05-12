package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientMasterModel {
	
	private String clientCode;

	private String clientName;
	
    private String companyRegistrationNo;
	
	private String website;
	
	private String telephone;
	
	private String industry;
	
    private String clientAddress1;
	
	private String clientAddress2;
	
	private String clientCity;
	
	private String clientState;
	
	private String clientCountry;
	
	private String clientZipCode;
	
	private String clientCurrency;
	
	private String gstIn;
	
    private String services;

	private String contactName;

	private String contactDesignation;
	
	private String contactEmail;
	
	private String contactTelephone;
	
    private String panNumber;

}
