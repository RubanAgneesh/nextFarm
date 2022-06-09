package com.internaltools.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
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

public class Country {

    private static final Long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

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
