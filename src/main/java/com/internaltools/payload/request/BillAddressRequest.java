package com.internaltools.payload.request;

import com.internaltools.service.model.BillAddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BillAddressRequest {
    private BillAddressModel billAddressModel;
}
