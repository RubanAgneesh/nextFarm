package com.internaltools.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.google.firebase.database.annotations.NotNull;

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

	
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientCode;

	private String clientName;


	@NotNull
	private String companyRegistrationNo;

	@NotNull
	private String website;

	private String telephone;

	private String industry;

	private String clientAddress1;

	private String clientAddress2;

	private String clientCity;

	private String clientState;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "countryId")
	private Country country;

	private String clientZipCode;

	private String gstIn;

	private String services;

	private String contactName;

	private String contactDesignation;

	private String contactEmail;

	private String contactTelephone;

	private String panNumber;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "companyId")
	private Company company;

	public Long getCompanyID() {
		// TODO Auto-generated method stub
		return null;
	}


}
