package com.jdc.token.exceptions;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.token.model.dto.ErrorResult;
import com.jdc.token.model.dto.ErrorResult.Type;

@RestControllerAdvice
public class ExceptionHandlers {
	
	private Logger logger = LoggerFactory.getLogger(ExceptionHandlers.class);
	private final Map<Class<? extends AuthenticationException>, String> authenticationErrors 
		= Map.of(
				UsernameNotFoundException.class, "Please check your login id.",
				BadCredentialsException.class, "Please check your password"
				);

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorResult handle(ValidationFailureException e) {
		logger.error("Validation Error");
		for(var message : e.getMessages()) {
			logger.error(message);
		}
		return new ErrorResult(Type.Validation, e.getMessages());
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorResult handle(NoSuchElementException e) {
		logger.error("No Element Error : {}", e.getMessage());
		return new ErrorResult(Type.Business, List.of(e.getMessage()));
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.FORBIDDEN)
	ErrorResult handle(AuthenticationException e) {
		var message = authenticationErrors.get(e.getClass());
		logger.error("No Element Error : {}", message);
		return new ErrorResult(Type.Authentication, 
				List.of(null != message ? message : "Authentication Error"));
	}
	
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.FORBIDDEN)
	ErrorResult handle(AccessDeniedException e) {
		logger.error("Access Denied Error : {}", e.getMessage());
		return new ErrorResult(Type.Authorization, List.of(e.getMessage()));
	}
	
	
}
