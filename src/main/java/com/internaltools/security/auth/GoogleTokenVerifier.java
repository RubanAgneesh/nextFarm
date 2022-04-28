package com.internaltools.security.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.internaltools.config.InternalToolsGoogleProperties;
import com.internaltools.exception.InvalidTokenException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GoogleTokenVerifier {

	@Autowired
	InternalToolsGoogleProperties docGoogleProperties;

	private final HttpTransport transport = new NetHttpTransport();
	private final JsonFactory jsonFactory = new JacksonFactory();

	public Payload verify(String idTokenString) throws GeneralSecurityException, IOException, InvalidTokenException {
		return verifyToken(idTokenString);
	}

	private Payload verifyToken(String idTokenString) throws GeneralSecurityException, IOException, InvalidTokenException {
		
		String clientId = docGoogleProperties.getClient_id();
		final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier
				.Builder(transport, jsonFactory)
				.setIssuers(Arrays.asList("https://accounts.google.com", "accounts.google.com"))
				.setAudience(Collections.singletonList(clientId)).build();

		log.debug("GoogleTokenVerifier :: verifyToken :: validating: {}", idTokenString);
		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(idTokenString);
		} catch (IllegalArgumentException e) {
			log.debug("GoogleTokenVerifier :: verifyToken ::catch IllegalArgumentException - token was not valid and idToken will be null");
		}
		if (idToken == null) {
			throw new InvalidTokenException("idToken is invalid");
		}
		return idToken.getPayload();
	}
}