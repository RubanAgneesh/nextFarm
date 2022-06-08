package com.internaltools.payload.request;

import com.internaltools.service.model.BankModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BankRequest {
    private BankModel bankModel;
}
