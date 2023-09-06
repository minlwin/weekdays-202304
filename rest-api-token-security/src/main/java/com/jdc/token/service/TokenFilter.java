package com.jdc.token.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class TokenFilter extends OncePerRequestFilter{
	
	@Autowired
	private TokenProvider tokenProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		var token = request.getHeader("Authorization");
		var authorization = tokenProvider.parse(token);
		
		if(null != authorization && authorization.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authorization);
		}
		
		filterChain.doFilter(request, response);
	}

}
