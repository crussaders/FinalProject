package com.cognizant.medRepSchedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class MedicalRepresentativeScheduleServiceApplication {
	
	/*
	 * Main Class for spring boot application
	 * */

	public static void main(String[] args) {
		SpringApplication.run(MedicalRepresentativeScheduleServiceApplication.class, args);
	}

	/*
	 * Swagger Integration
	 */

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("MedRepSchedule-api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant.medRepSchedule")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Medical Rep meetings API")
				.description("Medical Representative schedule meeting API reference for developers")
				.termsOfServiceUrl("http://www.cognizant.com").license("Cognizant License")
				.licenseUrl("GEN-C@cognizant.com").version("1.0").build();
	}

}
