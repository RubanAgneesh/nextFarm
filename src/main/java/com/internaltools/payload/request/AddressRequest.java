package com.internaltools.payload.request;

import com.internaltools.service.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressRequest {
    private AddressModel addressModel;
}
