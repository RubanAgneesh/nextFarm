package com.internaltools.config.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class InternalToolsEmailConfigurations {
	
	@Value("${spring.mail.username}")
	private String senderEmailId;

	@Value("${documends.documends-web.url}")
	private String documendsWebUrl;
	
	@Value("${documends.documends-web.registerUrl}")
	private String registrationUrl;

	
	
}
