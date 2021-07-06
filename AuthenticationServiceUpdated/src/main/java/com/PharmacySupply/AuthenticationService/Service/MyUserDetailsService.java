package com.PharmacySupply.AuthenticationService.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.PharmacySupply.AuthenticationService.Exception.UserNotFoundException;
import com.PharmacySupply.AuthenticationService.model.MyUserDetails;
import com.PharmacySupply.AuthenticationService.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
/********************************************************
 * MyUserDetailsService is used to return the details of the
 * user for authentication if user present then that user is
 * authenticated 
 ********************************************************/
public class MyUserDetailsService implements UserDetailsService{
 
	@Autowired
	private UserRepository repository;
	@Autowired
	private Environment env;
	/*
	 * loadUserByUsername take user id as argument and find user in database 
	 * by the help of userRespository and if user present then it will return
	 * user or else it will throw UserNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.info(env.getProperty("log.start"));
		MyUserDetails uname = repository.findById(userId).orElseThrow(() -> new UserNotFoundException(env.getProperty("ex.usernotfound")));
		log.debug(env.getProperty("log.userDetails"),uname);
		log.info(env.getProperty("log.end"));
		return new User(uname.getUserid(),uname.getPassword(),new ArrayList<>());
	}

}
