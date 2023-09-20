package com.jdc.goldern.members.model.utils.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.jdc.goldern.members.model.utils.exceptions.ApiSecurityException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class SecurityExceptionResolver implements AuthenticationEntryPoint, AccessDeniedHandler{

	@Autowired
	private HandlerExceptionResolver handlerExceptionResolver;
	
	private final Map<Class<? extends AuthenticationException>, String> messages = new HashMap<>();
	
	{
		messages.put(UsernameNotFoundException.class, "Please check your login email.");
		messages.put(BadCredentialsException.class, "Please check your password.");
		messages.put(DisabledException.class, "Your account is disabled, please contact to admin team.");
		messages.put(LockedException.class, "Your account is locked, please contact to admin team.");
		messages.put(AccountExpiredException.class, "Your account is expired, please contact to admin team.");
	}
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		handlerExceptionResolver.resolveException(request, response, null, new ApiSecurityException(messages.get(authException.getClass())));
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		handlerExceptionResolver.resolveException(request, response, null, new ApiSecurityException("You have no permission for this operation."));
	}

}
