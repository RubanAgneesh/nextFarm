package com.internaltools.payload.response;

import com.internaltools.service.model.CompanyModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CompanyResponse extends ApiResponse{
    private static final long serialVersionUID = 1;

    private CompanyModel companyModel;

    private long companyId;
}
