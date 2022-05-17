package com.internaltools.persistence.repository;

import com.internaltools.persistence.entity.BankEntity;
import com.internaltools.persistence.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    /**
     * @author Ruban
     *
     */
    @Repository

    public interface BankRepository extends JpaRepository<BankEntity,String> {

    }

