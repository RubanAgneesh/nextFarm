package com.internaltools.persistence.repository;

import com.internaltools.persistence.entity.BillAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ruban
 *
 */
@Repository
public interface BillAddressRepository extends JpaRepository<BillAddress,String> {

}
