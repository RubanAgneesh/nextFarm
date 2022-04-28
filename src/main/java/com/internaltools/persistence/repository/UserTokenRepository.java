package com.internaltools.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.internaltools.persistence.entity.UserToken;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {
	
	/**
	 * Optional<UserToken>
	 */
	@Override
	Optional<UserToken> findById(Long id);

	/**
	 * @param token
	 * @return Optional<UserToken>
	 */
	Optional<UserToken> findByToken(String token);
	
	/**
	 * @param userId
	 * @return int
	 */
	@Modifying
	@Transactional
	@Query("Update UserToken token set token.isActive= 'N' where token.userid = :userId")
	int inactiveAllTokenForUser(Long userId);
}
