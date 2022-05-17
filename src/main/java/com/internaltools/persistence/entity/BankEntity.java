package com.internaltools.persistence.entity;


import com.amazonaws.services.kinesisanalytics.model.S3ReferenceDataSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String bankId;

    private String bankName;

    private String ifscCode;

    private String branchName;

    private String accountHolderName;

    private String accountNumber;

    private String reenterAccountNumber;

    private String swiftCode;

}
