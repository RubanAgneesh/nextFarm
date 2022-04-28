package com.documends.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.internaltools.config.InternalToolsGoogleProperties;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class JsonPropertiesIntegrationTest {

	@Autowired
	private InternalToolsGoogleProperties jsonProperties;

	@Test
	public void whenPropertiesLoadedViaJsonPropertySource_thenLoadFlatValues() {
		assertEquals("test-882@documends-280015.iam.gserviceaccount.com", jsonProperties.getClient_email());
		assertEquals("105628133216030213314", jsonProperties.getClient_id());
	}
}