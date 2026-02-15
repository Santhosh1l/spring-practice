package com.security.springSecurity1.utils;

import java.time.Instant;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtUtils{
	
	private final String secretKey = "${SECRETKEY}";
	
	public String generateToken(UserDetails user) {
		return Jwts.builder()
				.addClaims(new HashMap<String, Object>())
				.setSubject(user.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
				.signWith(generateKey())
				.compact();
	}
	
	public SecretKey generateKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
	}

	public String getUsername(String token) {
		return extractAllClaims(token).getBody().getSubject();
	}
	
	public Jws<Claims> extractAllClaims(String token){
		return Jwts.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(token);
	}

	public boolean validateToken(String token, UserDetails userData) {
		try {
			Claims claim = extractAllClaims(token).getBody();
			
			return userData.getUsername().equals(claim.getSubject()) &&
					claim.getExpiration().after(new Date());
			
		} catch (JwtException e) {
			return false;
		}
	}
	
	
	
	

}
