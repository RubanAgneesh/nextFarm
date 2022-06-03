package com.internaltools.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internaltools.persistence.entity.User;

/**
 * @author Pirai
 *
 */


@Repository


public interface UserRepository extends JpaRepository<User, Long> {

//	/**
//	 * @param lowerCase
//	 * @return
//	 */
//	Optional<User> findByUserName(String lowerCase);


}




