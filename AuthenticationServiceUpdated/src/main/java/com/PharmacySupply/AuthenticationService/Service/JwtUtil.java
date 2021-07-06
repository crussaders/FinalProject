package com.PharmacySupply.AuthenticationService.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
/*********************************************************************************
 * JwtUtil class is a Utility class used for Generating token,validate token check for token exipration 
 * extractUsername => extractUsername from claims
 * extractExpiration => extract ExpirationTime from claims
 * extractClaim => extract claim
 * isTokenExpired => check is token expire or not
 * generateToken => it will generate the token
 * validateToken => it will validate the token
 ***********************************************************************************/
public class JwtUtil {
	@Autowired
	private Environment env;
	//PharmacySupply
	private final String secretKey="$2y$12$klnJCAb6IhEsGEB/4CR/Kuq19p8oaDF7Uz/x2BxCU3uslLb2DHGZC";
	/*
	 * This method Extract Username from claims 
	 */
	public String extractUsername(String token) throws ExpiredJwtException {
		
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.token"),token);
		String userId = extractClaim(token, Claims::getSubject);
		log.debug(env.getProperty("log.claim"),userId);
		log.info(env.getProperty("log.end"));
		return userId;
	}
	/*
	 * This method Extract Token Expiration time from claims 
	 */
	public Date extractExpiration(String token) throws ExpiredJwtException {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.token"),token);
		Date expirationTime = extractClaim(token, Claims::getExpiration);
		log.debug(env.getProperty("log.expire"),expirationTime);
		log.info(env.getProperty("log.end"));
		return expirationTime;
	}
	/*
	 * This method Extract claim 
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws ExpiredJwtException {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.token"),token);
		log.debug(env.getProperty("log.claimsResolver"),claimsResolver);
		final Claims claims = extractAllClaims(token);
		log.debug(env.getProperty("log.claim"),claims);
		log.info(env.getProperty("log.end"));
		return claimsResolver.apply(claims);
	}
	/*
	 * This method Extract  all claims from token 
	 */
	private Claims extractAllClaims(String token) throws ExpiredJwtException {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.token"),token);
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		log.debug(env.getProperty("log.claim"),claims);
		log.info(env.getProperty("log.end"));
		return claims;
	}
	/*
	 * This method check weather the given token is Expired or not
	 */
	private Boolean isTokenExpired(String token) throws ExpiredJwtException {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.token"),token);
		boolean isTokenExpired = extractExpiration(token).before(new Date());
		log.debug(env.getProperty("log.checktime"),isTokenExpired);
		log.info(env.getProperty("log.end"));
		return isTokenExpired;
	}
	/*
	 * This method will takes userdetails as parameter and generate JwtToken
	 */
	public String generateToken(UserDetails userDetails) {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.userDetails"),userDetails);
		Map<String, Object> claims = new HashMap<>();
		log.debug(env.getProperty("log.claim"),claims);
		String createToken = createToken(claims, userDetails.getUsername());
		log.debug(env.getProperty("log.tokenCreate"),createToken);
		log.info(env.getProperty("log.end"));
		return createToken;
	}
	/*
	 * This method will take Claims and userId as parameter and create the Jwt token
	 */
	private String createToken(Map<String, Object> claims, String subject) {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.claim"),claims);
		log.debug(env.getProperty("log.subject"),subject);
		String token = Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))// token for 30 mins
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
		log.debug(env.getProperty("log.token"),token);
		log.info(env.getProperty("log.end"));
		return token;
	}
	/*
	 * This method takes token and userdetails as arguments and check weather token it valid or not
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.token"),token);
		log.debug(env.getProperty("log.userDetails"),userDetails);
		final String userId = extractUsername(token);
		log.debug(env.getProperty("log.subject"),userId);
		log.info(env.getProperty("log.end"));
		return (userId.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	/*
	 * This method takes token  as arguments and check weather token it valid or not
	 */
	public Boolean validateToken(String token) throws ExpiredJwtException {
		log.info(env.getProperty("log.start"));
		log.debug(env.getProperty("log.token"),token);
		log.info(env.getProperty("log.end"));
		return !isTokenExpired(token);
	}

}
