package com.internaltools.persistence.entity;

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
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private String company;

    private String date;

    private String invoiceNo;

    private String tax;

    private String bankDetails;

    private String billedTo;

    private String totalAmount;

    private String notes;

    private String mailedBy;

    private String poDetails;
}