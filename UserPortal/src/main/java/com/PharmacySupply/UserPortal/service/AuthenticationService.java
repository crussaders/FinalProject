package com.PharmacySupply.UserPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PharmacySupply.UserPortal.HeaderToken;
import com.PharmacySupply.UserPortal.feign.AuthenticationFeign;
import com.PharmacySupply.UserPortal.model.UserLoginCredentails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationService {
	@Autowired
	private AuthenticationFeign authfeign;
	@Autowired
	private HeaderToken authtoken;
	public ResponseEntity<?> getToken(UserLoginCredentails usercredentials) {
		log.debug("userCredentials{}:", usercredentials);
		return authfeign.login(usercredentials);
	}
	public boolean verifyToken(String token)
	{
		boolean ans=false;
		String tokenWithHeader = authtoken.getTokenWithHeader(token);
		if(authfeign.verifyToken(tokenWithHeader).isValid())
		{
			ans=true;
		}
		return ans;
	}
}
