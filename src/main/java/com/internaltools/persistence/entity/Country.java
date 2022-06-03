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

import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited

public class Country {

    private static final String serialVersionUID = "1";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String countryId;

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
