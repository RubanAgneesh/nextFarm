package com.internaltools.service;

import com.internaltools.payload.request.CompanyRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.payload.response.CompanyResponse;
import com.internaltools.service.model.CompanyModel;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Ruban
 *
 */

public interface CompanyService {
    /**
     * @param request
     * @return
     */
    ApiResponse createCompany(@Valid CompanyRequest request);

    CompanyResponse getByCompanyId(Long companyId);
    List<CompanyModel> getCompanyList();
}
