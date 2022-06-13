package com.internaltools.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.Long;
import lombok.*;
import org.hibernate.envers.Audited;


import javax.validation.constraints.NotBlank;
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



public class Company {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long companyId;

    private String companyCode;

    @NotBlank(message = "Company Name is Required")
    private String companyName;

    private String website;

    private String startDate;

    @NotBlank(message = "Pan Number is Required")
    private String panNumber;

    @NotBlank(message = "GSTIN is Required")
    private String gstin;

    private String telephoneNumber;

    @NotBlank(message = "Registration Number is Required")
    private String registerationNumber;

    private String services;

    @NotBlank(message = "Bank Details is Required")
    private String bankDetails;


    @NotBlank(message = "Invoice Prefix is Required")
    private String invoicePrefix;


    //Bank Details
    @NotBlank(message = "Bank Name is Required")
    private String bankName;

    @NotBlank(message = "IFSC Code is Required")
    private String ifscCode;

    @NotBlank(message = "Branch Name is Required")
    private String branchName;

    @NotBlank(message = "Account Holder Name is Required")
    private String accountHolderName;

    @NotBlank(message = "Account Number is Required")
    private String accountNumber;

    @NotBlank(message = "Re-Enter Account Number is Required")
    private String reenterAccountNumber;

    @NotBlank(message = "Swift Code is Required")
    private String swiftCode;

    //Contact Address Details

    @NotBlank(message = "Address Line1 is Required")
    private String contactAddress1;

    @NotBlank(message = "Address Line2 is Required")
    private String contactAddress2;

    @NotBlank(message = "Country is Required")
    private String contactCountry;

    @NotBlank(message = "City is Required")
    private String contactCity;

    @NotBlank(message = "State is Required")
    private String contactState;

    @NotBlank(message = "Zip Code is Required")
    private String contactZipCode;

    private Boolean primaryAddress;


    @NotBlank(message = "Contact Name is Required")
    private String contactName;


    @NotBlank(message = "Contact Designation is Required")
    private String contactDesignation;


    @NotBlank(message = "email Id  is Required")
    private String contactEmailId;

    @NotBlank(message = "Phone Number is Required")
    private String contactPhoneNumber;

//Address
    @NotBlank(message = "Contact Address  is Required")
    private  String companyAddress1;

    @NotBlank(message = "Contact Address  is Required")
    private String companyAddress2;

    @NotBlank(message = "Country  is Required")
    private  String companyCountry;

    @NotBlank(message = "City  is Required")
    private String companyCity;

    @NotBlank(message = "State is Required")
    private String companyState;

    @NotBlank(message = "Zip Code is Required")
    private String companyZipCode;

    private Boolean isBilling;

	public String AddressDetails;

	public String ContactAddressDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}
