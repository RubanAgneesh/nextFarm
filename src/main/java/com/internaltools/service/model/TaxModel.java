package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TaxModel {

    private Long taxId;

    private String taxType;

    private String taxPercentage;

    private Boolean taxStatus;
}
