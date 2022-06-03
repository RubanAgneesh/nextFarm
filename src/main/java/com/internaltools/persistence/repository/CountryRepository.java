package com.internaltools.persistence.repository;


import com.internaltools.persistence.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    /**
     *
     * @param countryCode
     * @return
     */

    List<Country> findByCountryCode(String countryCode);


}
