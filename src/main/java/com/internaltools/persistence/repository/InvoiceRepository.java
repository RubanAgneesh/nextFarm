package com.internaltools.persistence.repository;

import com.internaltools.persistence.entity.Company;
import com.internaltools.persistence.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,String> {

    @Override
    List<Invoice> findAll();
}
