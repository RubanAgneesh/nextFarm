package com.internaltools.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BankModel {


    private String bankName;

    private  String bankId;

    private String ifscCode;

    private String branchName;

    private String accountHolderName;

    private String accountNumber;

    private String reenterAccountNumber;

    private String swiftCode;
}
