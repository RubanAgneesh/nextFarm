package com.internaltools.config;

import java.io.IOException;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@PropertySource(value = "classpath:documends.json", factory = InternalToolsGoogleProperties.JsonLoader.class)
@ConfigurationProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalToolsGoogleProperties {

	private String type;
	private String project_id;
	private String private_key_id;
	private String private_key;
	private String client_email;
	private String client_id;
	private String auth_uri;
	private String token_uri;
	private String auth_provider_x509_cert_url;
	private String client_x509_cert_url;

	static class JsonLoader implements PropertySourceFactory {

		@Override
		public org.springframework.core.env.PropertySource<?> createPropertySource(String name,
				EncodedResource resource) throws IOException {
			Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);
			return new MapPropertySource("json-source", readValue);
		}

	}
}
