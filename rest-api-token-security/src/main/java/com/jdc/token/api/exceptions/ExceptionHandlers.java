package com.jdc.token.api.exceptions;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.token.model.ErrorResponse;
import com.jdc.token.model.ErrorResponse.Type;

@ControllerAdvice
@RestControllerAdvice
public class ExceptionHandlers {
	
	private final Map<Class<? extends AuthenticationException>, String> authenticationErrors 
		= Map.of(
				UsernameNotFoundException.class, "Please check your login id.",
				BadCredentialsException.class, "Please check your password"
				);
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse handle(AccessDeniedException e) {
		return new ErrorResponse(Type.Authorization, 
				List.of("You have no permission for this operation."));
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse handle(AuthenticationException e) {
		var message = authenticationErrors.get(e.getClass());
		return new ErrorResponse(Type.Authentication, 
				List.of(null != message ? message : "Authentication Error"));
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handle(ValidationFailureException e) {
		return new ErrorResponse(Type.Validation, e.getMessages());
	}
	
}
