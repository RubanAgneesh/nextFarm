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



public class Company {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long companyId;

    private String companyCode;

//    @NotBlank(message = "Company Name is Required")
    private String companyName;

    private String website;

    private String startDate;



//   @NotBlank(message = "Pan Number is Required")
    private String panNumber;

//   @NotBlank(message = "GSTIN is Required")
    private String gstin;

    private String telephoneNumber;

//    @NotBlank(message = "Registration Number is Required")
    private String registerationNumber;

    private String services;

//    @NotBlank(message = "Bank Details is Required")
    private String bankDetails;

//    @NotBlank(message = "Address Details is Required")
    private String addressDetails;

//   @NotBlank(message = "Contact Address Details is Required")
    private String contactAddressDetails;

//   @NotBlank(message = "Invoice Prefix is Required")
    private String invoicePrefix;

}