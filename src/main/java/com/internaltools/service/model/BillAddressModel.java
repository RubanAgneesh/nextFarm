package com.internaltools.service.model;

import com.internaltools.persistence.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BillAddressModel {
    private Company company;

    private  String addressLine1;

    private String addressLine2;

    private String city;

    private String country;

    private String state;

    private String zipCode;

    private Boolean isBilling;

}
