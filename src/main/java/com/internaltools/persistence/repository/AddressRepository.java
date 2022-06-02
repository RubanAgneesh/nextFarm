package com.internaltools.persistence.repository;

import com.internaltools.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ruban
 *
 */
@Repository

public interface AddressRepository extends JpaRepository<Address,String> {
}
