package com.internaltools.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class ClientMaster {

	private static final String serialVersionUID = "1";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
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
