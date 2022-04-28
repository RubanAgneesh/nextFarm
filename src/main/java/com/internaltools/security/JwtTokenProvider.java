package com.internaltools.security;

import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.internaltools.exception.InvalidTokenException;
import com.internaltools.persistence.entity.UserToken;
import com.internaltools.service.TokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	@Autowired
	TokenService tokenService;

	public static final String ROLES = "ROLES";

	public String generateToken(Authentication authentication) {
		log.debug("****** Entering into generateToken *****");
		return generateToken((UserPrincipal) authentication.getPrincipal());

	}

	public String generateToken(UserPrincipal userPrincipal) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		log.debug("jwtExpirationInMs :: ", jwtExpirationInMs);
		return Jwts.builder().setSubject(Long.toString(userPrincipal.getId())).setIssuedAt(new Date())
				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		log.debug("getUserIdFromJWT :: token :: ", token);
		return Long.parseLong(claims.getSubject());
	}

	public String getUserIdFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}


	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// for retrieving any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// validate token
	public Boolean validateToken(String token) {
		try {
			log.debug("getUservalidateTokenIdFromJWT :: authToken :: ", token);
			if (!StringUtils.isNotBlank(getUserIdFromToken(token)) && !isTokenExpired(token)) {
				return false;
			}
			return validateTokenIsNotForALoggedOut(token);
		} catch (SignatureException ex) {
			logger.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			logger.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			logger.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			logger.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			logger.error("JWT claims string is empty.");
		} catch (InvalidTokenException ex) {
			logger.error(ex.getMessage());
		}
		return false;
	}

	private boolean validateTokenIsNotForALoggedOut(String token) {
		Optional<UserToken> userToken = tokenService.findByToken(token);
		userToken.orElseThrow(() -> new InvalidTokenException("Token is not available"));
		UserToken userTokenInfo = userToken.get();
		if (StringUtils.isNotBlank(userTokenInfo.getIsActive()) && userTokenInfo.getIsActive().equalsIgnoreCase("N")) {
			String errorMessage = String.format(
					"Token corresponds to an already logged out user [%s]  Please login again",
					userTokenInfo.getUserName());
			throw new InvalidTokenException(errorMessage);
		}
		return true;
	}

}
