package com.sv.demo.config;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	private static final String KEY = "demo";

	public String generateToken(UserDetails userDetail) {
		return Jwts.builder().setSubject(userDetail.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 68 * 68 * 10))
				.signWith(SignatureAlgorithm.HS256, KEY).compact();
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		return userDetails.getUsername().equals(extractUserName(token)) && !isTokenExpired(token);
	}

	public String extractUserName(String token) {
		return getClaims(token).getSubject();
	}

	public boolean isTokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}

	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
	}

}
