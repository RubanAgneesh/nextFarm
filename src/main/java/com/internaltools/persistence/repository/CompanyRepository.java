package com.internaltools.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internaltools.persistence.entity.Company;
import com.internaltools.persistence.entity.Country;

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

	//static Optional<Country> findById(Long countryId);
	

}
