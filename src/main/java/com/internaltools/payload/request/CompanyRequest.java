package com.internaltools.payload.request;

import com.internaltools.service.model.CompanyModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CompanyRequest {
    private CompanyModel companyModel;
}
