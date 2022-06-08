package com.internaltools.service.model;

import com.internaltools.persistence.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressModel {
    private Company company;

    private String addressTypeId;


    private String addressLine1;

    private String addressLine2;

    private String county;

    private String city;

    private String state;

    private String zipCode;

    //Contact Address Details
    private String contactName;

    private String contactDesignation;

    private String emailId;

    private String phoneNumber;

//    private Boolean isBilling;
}
