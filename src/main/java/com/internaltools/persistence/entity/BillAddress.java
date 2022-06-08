package com.internaltools.persistence.entity;

import com.amazonaws.services.dynamodbv2.xspec.S;
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

public class BillAddress {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String addressId;

    private  String addressLine1;

    private String addressLine2;

    private String city;

    private String country;

    private String state;

    private String zipCode;

    private Boolean isBilling;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "COMPANY_COMPANY_CODE", referencedColumnName = "companyCode")
    private  Company company;
}
