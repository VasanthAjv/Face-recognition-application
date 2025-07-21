package com.example.face_recognition_applicaton.users.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtil {

	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private long expiration;
	
	public String generateToken(String email,String role)
	{
		Map<String,Object>claims=new HashMap<>();
		claims.put("role", role);
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(SignatureAlgorithm.HS256,secret)
				.compact();
	}
	
	public String getEmailFromToken(String token)
	{
		return getAllClaimsFromToken(token).getSubject();
	}
	
	public String getRoleFromToken(String token) {
		return (String) getAllClaimsFromToken(token).get("role");
	}
	
	public boolean isTokenExpired(String token)
	{
		 return getAllClaimsFromToken(token).getExpiration().before(new Date());
	}
	
	public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
	 private Claims getAllClaimsFromToken(String token) {
	        return Jwts.parser()
	                   .setSigningKey(secret)
	                   .parseClaimsJws(token)
	                   .getBody();
	    }
	
}
