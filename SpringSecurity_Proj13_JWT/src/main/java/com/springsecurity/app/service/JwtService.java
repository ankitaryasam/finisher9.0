package com.springsecurity.app.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	//secret key
	private static final String SECRET_KEY = "4sgdsdg4578gd78";
	
	
	//generate token
	public String generateToken(String email) {
		Map<String, Object> claims = new HashMap<String, Object>();
		String token = createToken(claims, email);
		return token;
	}
	
	
	private String createToken(Map<String, Object> claims, String email) {
		
	return	Jwts.builder()
			.setClaims(claims)
			.setSubject(email)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
			.signWith(getSignKey(), SignatureAlgorithm.HS256)
			.compact();
		
	}
	
	//get the signing key for jwt token
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	//extract the username or email from the token --> sub claim value
	public String extractEmailFromToken(String token) {
		return extractClaim(token, Claims::getSubject);	
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	
	
	//this is a generic method to extract the any claim value
	public  <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}
	
	//validates the token if it is correct or not
	public Boolean validateToken(String token, UserDetails userDetails) {
		String email = extractEmailFromToken(token);
		return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
		    .setSigningKey(getSignKey())
		    .build()
		    .parseClaimsJws(token)
		    .getBody();
	}
	
	//check if the token is expired or not
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	
	
	

}
