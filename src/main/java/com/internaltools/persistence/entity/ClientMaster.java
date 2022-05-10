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
	
	private String clientAddress;
	
	private String website;
	
	private String telephone;
	
	private String industry;
	
	private String address;

	private String services;

	private String contactName;

	private String contactDesignation;
	
	private String contactEmail;
	
	private String contactTelephone;
	
	private String gstIn;

	private String panNumber;
	
	private String contactPhoneNumber;

	private String companyRegistrationNo;
	
	private String bankName;
	
	private String branch; 
	
	private String ifscCode;
	
	private String accountType;
	
	private String accountNumber;

}
