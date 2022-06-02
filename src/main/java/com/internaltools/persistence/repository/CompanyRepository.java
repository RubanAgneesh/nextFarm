package com.internaltools.persistence.repository;

import com.internaltools.persistence.entity.Company;
import com.stripe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Ruban
 *
 */
@Repository

public interface CompanyRepository extends JpaRepository<Company,Long > {
    /**
     *
     * @param companyId
     * @return
     */


    Optional<Company> findByCompanyId(Long companyId);


}
