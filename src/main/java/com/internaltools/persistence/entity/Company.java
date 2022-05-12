package com.internaltools.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited



public class Company {
    private static final String serialVersionUID = "1";


    private String companyName;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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
