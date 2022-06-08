package com.internaltools.persistence.entity;

import com.amazonaws.services.dynamodbv2.xspec.S;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited

public class Address {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String addressTypeId;
  @NotBlank(message = "Address Line1 is Required")
    private String addressLine1;

  @NotBlank(message = "Address Line2 is Required")
    private String addressLine2;

  @NotBlank(message = "Country is Required")
    private String county;

  @NotBlank(message = "City is Required")
    private String city;

  @NotBlank(message = "State is Required")
    private String state;

  @NotBlank(message = "Zip Code is Required")
    private String zipCode;

    //Contact Address Details
    @NotBlank(message = "Contact Name is Required")
    private String contactName;


  @NotBlank(message = "Contact Designation is Required")
    private String contactDesignation;


  @NotBlank(message = "email Id  is Required")
    private String emailId;

  @NotBlank(message = "Phone Number is Required")
    private String phoneNumber;

  //  @ManyToOne(fetch = FetchType.LAZY, optional = true)
//  @JoinColumn(name = "COMPANY_COMPANY_CODE", referencedColumnName = "companyCode")
//  private  Company company;


  // Address Details

//  private  String addressLine1;
//
//  private String addressLine2;
//
//  private String city;

//  private String state;
//
//  private String zipCode;
  private String country;

  private Boolean isBilling;

}
