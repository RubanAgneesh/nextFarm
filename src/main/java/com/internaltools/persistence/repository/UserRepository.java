package com.internaltools.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internaltools.persistence.entity.User;

/**
 * @author Pirai
 *
 */


@Repository


public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String lowerCase);

}




