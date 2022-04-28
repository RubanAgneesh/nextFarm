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


	/**
	 * @param roleName
	 * @return Optional<RoleMaster>
	 */
	Optional<RoleMaster> findByRoleName(String roleName);

	/**
	 * @param active
	 * @return Optional<RoleMaster>
	 */
	List<RoleMaster> findByActive(boolean active);

	/**
	 * @param id
	 * @return
	 */
	List<RoleMaster> findByIdAndActiveTrueAndHiddenFalse(Long id);

	List<RoleMaster> findByUserIdAndActiveTrueAndHiddenFalse(Long id);

	List<RoleMaster> findByUserIdInAndActiveTrueAndHiddenFalse(List<Long> ids);
}
