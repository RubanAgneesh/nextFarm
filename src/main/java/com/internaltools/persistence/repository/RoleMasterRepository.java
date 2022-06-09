package com.internaltools.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internaltools.persistence.entity.RoleMaster;

/**
 * @author loganathan
 *
 */
@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMaster, Long> {

}
