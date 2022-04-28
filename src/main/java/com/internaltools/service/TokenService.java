package com.internaltools.service;

import java.util.Optional;

import com.internaltools.persistence.entity.UserToken;

public interface TokenService {
	
	/**
	 * @param userToken
	 * @return UserToken
	 */
	UserToken saveUserToken(UserToken userToken);

	/**
	 * @param userId
	 */
	void inactiveAllTokenForUser(Long userId);

	/**
	 * @param token
	 * @return Optional<UserToken>
	 */
	Optional<UserToken> findByToken(String token);

	/**
	 * @param userId
	 * @param userName
	 * @param token
	 * @return UserToken
	 */
	UserToken createUserToken(String userId, String userName, String token);
}
