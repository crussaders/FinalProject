package com.PharmacySupply.AuthenticationService.Service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
/**********************
 * JwtRequestFilter is a filter which is applied on every incoming 
 * request this will examine the incoming request header and set the
 * authentication method of security context
 **********************/
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private MyUserDetailsService userdetails;
	@Autowired
	private JwtUtil jwtUtils;
	@Autowired
	private Environment env;
	/*
	 * doFilterInternal method intercepts the requests then check the
	 * Authorization header. If the header is not present or doesn't 
	 * start with "BEARER", it proceeds to the filter chain and if header
	 * is present the getAuthentication method is invoked.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.request"),request);
		log.debug(env.getProperty("log.response"),response);
		log.debug(env.getProperty("log.filterchain"),filterChain);
		final String header = request.getHeader("Authorization");
		log.debug(env.getProperty("log.bearertoken"),header);
		String userid=null;
		String jwt=null;
		if(header!=null && header.startsWith("Bearer "))
		{
		    jwt=header.substring(7);
		    log.debug(env.getProperty("log.token"),jwt);
		    userid=jwtUtils.extractUsername(jwt);
		    log.debug(env.getProperty("log.subject"),userid);
		}  
		 if(userid!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		 {
			 UserDetails userDetails = userdetails.loadUserByUsername(userid);
			 log.debug(env.getProperty("log.userDetails"),userDetails);
			 if(jwtUtils.validateToken(jwt, userDetails))
			 {
				 log.debug(env.getProperty("log.tokenvalid"));
				 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				 log.debug(env.getProperty("log.authtoken"), usernamePasswordAuthenticationToken);
				 usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			 }
		 }
		 log.info(env.getProperty("log.end"));
		 filterChain.doFilter(request, response);
	}

}
