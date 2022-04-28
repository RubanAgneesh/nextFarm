package com.internaltools.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internaltools.persistence.entity.User;

/**
 * @author loganathan
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * @param email
	 * @return Optional<User> 
	 */
	Optional<User> findByEmail(String email);
	
	/**
	 * @param username
	 * @param email
	 * @return Optional<User> 
	 */
	Optional<User> findByUsernameOrEmail(String username, String email);

	/**
	 * @return Long
	 */
	Long countByIsActiveTrue();

	/**
	 * @return Long
	 */
	Long countByIsActiveFalse();
	
	/**
	 * @return List<Optional<User>>
	 */
	List<Optional<User>> findByIsActiveTrue();
}
