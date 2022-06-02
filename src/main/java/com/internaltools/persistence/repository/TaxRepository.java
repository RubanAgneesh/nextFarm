package com.internaltools.persistence.repository;

import com.internaltools.persistence.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jahir
 *
 */

@Repository
public interface TaxRepository extends JpaRepository<Tax, String> {

    /**
     *
     * @param taxId
     * @return
     */

    List<Tax> findByTaxId(Long taxId);
}
