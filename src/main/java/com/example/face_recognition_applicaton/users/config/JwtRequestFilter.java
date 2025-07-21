package com.example.face_recognition_applicaton.users.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		    
		
		String authHeader=request.getHeader("Authourization");
		String email=null;
		String jwt=null;
		String role=null;
		  
		if(authHeader !=null && authHeader.startsWith("Bearer "))
		{
			jwt= authHeader.substring(7);
			email=jwtUtil.getEmailFromToken(jwt);
			role=jwtUtil.getRoleFromToken(jwt);
		}
		
		if(email !=null && SecurityContextHolder.getContext().getAuthentication()==null )
		{
			 if (jwtUtil.validateToken(jwt)) {
	                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
	                    email, null, Collections.singletonList(new SimpleGrantedAuthority(role))
	                );
	                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(auth);
	            }
		}
		chain.doFilter(request,response);
	}

}
