package com.internaltools.service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CountryModel {

    private Long countryId;

    private String countryName;

    private String countryCode;

    private String currencyCode;

    private String currencySymbol;

    private String timeZone;

    private String financialYearFrom;

    private String financialYearTo;

    private Timestamp createdDate;

    private Timestamp modifiedDate;
}
