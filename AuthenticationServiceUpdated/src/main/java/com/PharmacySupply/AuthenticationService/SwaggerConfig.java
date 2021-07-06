package com.PharmacySupply.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Slf4j
/***************************************************************
 * SwaggerConfig is a configuration class which is used to generate
 * RESTFUL API documents for RESTFUL web service. It provides a user 
 * interface to access our RESTful web services via the web browser
 ***************************************************************/
public class SwaggerConfig {
	@Autowired
	private Environment env;
	/*
	 * Docket Bean to configure Swagger2 for your Spring Boot application.
	 * We need to define the base package to configure REST API(s) for Swagger2 
	 */
	@Bean
	public Docket api() { 
		Docket docket= new Docket(DocumentationType.SWAGGER_2)  
					.select()                                  
					.apis(RequestHandlerSelectors.basePackage("com.PharmacySupply.AuthenticationService"))            
					.paths(PathSelectors.any())                          
					.build().apiInfo(apiDetails()); 
		log.debug("Docket{}:", docket);
		return docket;
		}
	/*
	 * This method configure  to set the title ,description in swagger-ui.html
	 */
	 private ApiInfo apiDetails() {
			ApiInfo apiInfo= new ApiInfoBuilder()
					.title(env.getProperty("swagg.title"))
					.description(env.getProperty("swagg.desc"))
					.build();
			log.debug("API Info{}:", apiInfo);
			return apiInfo;
		}

}
