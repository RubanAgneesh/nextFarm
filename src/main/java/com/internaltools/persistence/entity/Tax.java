package com.internaltools.persistence.entity;


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

public class Tax {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxId;

    private String taxType;

    private String taxPercentage;

    private Boolean taxStatus;

}
