package com.rent.service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rent.util.JwtUtil;

//import com.example.demo.service.RegisterUserService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
@Autowired
JwtUtil jwtUtilToken;
@Autowired
UserDetailsService userDetailsService;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
throws ServletException, IOException {
	
	javax.servlet.http.Cookie[] cookies = request.getCookies();
//	System.out.println("cookie"+cookies.toString());
//	System.out.println("cookie"+cookies[0].getValue());
//	System.out.println("cookie"+cookies["token"].getValue());
//final String authorizationHeader = request.getHeader("Authorization");
	 String token=null;
	  String authorizationHeader = request.getHeader("Authorization");
	 if(cookies!=null) {
		    for (javax.servlet.http.Cookie cookie : cookies) {
		      if(cookie.getName().equals("token")) {
		        token = cookie.getValue();
		        authorizationHeader = "Bearer "+token;
		      }
		    }
		  }
	
//	final String token =	cookies[0].getValue();
	
	System.out.println(authorizationHeader);
	
	
	
String username = null;
String jwt = null;
if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
jwt = authorizationHeader.substring(7);

 username = jwtUtilToken.extractUsername(jwt);
}
if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
UserDetails userDetails = userDetailsService.loadUserByUsername(username);
if(jwtUtilToken.validateToken(jwt, userDetails)) {
UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
userDetails, null, userDetails.getAuthorities());
usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
}
}
filterChain.doFilter(request, response);
}
}