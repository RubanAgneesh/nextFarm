package com.internaltools.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internaltools.persistence.entity.UserToken;
import com.internaltools.persistence.repository.UserTokenRepository;
import com.internaltools.service.TokenService;


@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	UserTokenRepository userTokenRepository;
	
	@Override
	public UserToken saveUserToken(UserToken userToken) {
		return userTokenRepository.save(userToken);
	}

	@Override
	public void inactiveAllTokenForUser(Long userId) {
		userTokenRepository.inactiveAllTokenForUser(userId);
	}

	@Override
	public Optional<UserToken> findByToken(String token) {
        return userTokenRepository.findByToken(token);
	}

	@Override
	public UserToken createUserToken(String userId, String userName, String token) {
		UserToken userToken = new UserToken();
		userToken.setCreatedBy(userId);
		userToken.setIsActive("Y");
		userToken.setToken(token);
		userToken.setId(Long.valueOf(userId));
		userToken.setUserName(userName);
		return userToken;
	}
}
