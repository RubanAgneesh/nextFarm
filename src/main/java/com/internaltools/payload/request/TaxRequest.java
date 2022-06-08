package com.internaltools.payload.request;

import com.internaltools.service.model.TaxModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxRequest {
    private TaxModel taxModel;
}
