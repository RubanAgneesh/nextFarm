package com.internaltools.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport  {
	
	
	@Bean
	public Docket productApi() {
		
		List<SecurityContext> secuContext = new ArrayList<>();
		secuContext.add(securityContext());
		return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build()
	            .securitySchemes(apiKey())
	            .securityContexts(secuContext)
	            .useDefaultResponseMessages(false)
	            .apiInfo(apiInfo());
	}

	
	@Bean
	SecurityContext securityContext() {
	    return SecurityContext.builder()
	            .securityReferences(defaultAuth())
	            .forPaths(PathSelectors.any())
	            .build();
	}

	List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope
	            = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    List<SecurityReference> securityReference = new ArrayList<>();
	    securityReference.add(new SecurityReference("JWT", authorizationScopes));
	    return securityReference;
	}

	private List<ApiKey> apiKey() {
		List<ApiKey> apiKey = new ArrayList<>();
		apiKey.add(new ApiKey("JWT", "Authorization", "header"));
	    return apiKey;
	}
	
	
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Internal Tools").description("Documentation for InternalTools").version("1.0").build();
	}
}
