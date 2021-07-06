package com.PharmacySupply.UserPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class UserPortalApplication {

	public static void main(String[] args) {
		log.info("START");
		SpringApplication.run(UserPortalApplication.class, args);
		log.info("END");
	}

}
