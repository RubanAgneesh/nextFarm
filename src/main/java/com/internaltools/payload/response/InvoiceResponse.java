package com.internaltools.payload.response;

import com.internaltools.service.model.CompanyModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class InvoiceResponse extends ApiResponse{
    private static final long serialVersionUID = 1;

    private List<CompanyModel> companyModelList;

    private long companyId;
}
