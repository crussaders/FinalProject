package com.PharmacySupply.UserPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PharmacySupply.UserPortal.HeaderToken;
import com.PharmacySupply.UserPortal.feign.RepresentativeFeign;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RepresentativeService {
	@Autowired
	private HeaderToken authtoken;
	@Autowired
	private RepresentativeFeign repfeign;
	
	public ResponseEntity<?> getRepSchedule(String token, String scheduleStartDate) {
		log.debug("token {}:", token);
		ResponseEntity<?> response = repfeign.getRepSchedule(authtoken.getTokenWithHeader(token), scheduleStartDate);
		log.debug("response {}", response);
		return response;
	}

}
