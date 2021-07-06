package com.PharmacySupply.UserPortal;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HeaderToken {
	public String getTokenWithHeader(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		log.debug("headers{}:", headers);
		String AuthToken = headers.getFirst("Authorization");
		log.debug("first {}:", AuthToken);
		return AuthToken;
	}

}
