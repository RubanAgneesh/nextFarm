package com.internaltools.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internaltools.persistence.entity.ClientMaster;

/**
 * @author Pirai
 *
 */
@Repository

public interface ClientMasterRepository extends JpaRepository<ClientMaster, Long> {
	
		
}
