package com.jdc.goldern.members.model.utils.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.goldern.members.model.dto.ErrorResponse;
import com.jdc.goldern.members.model.dto.ErrorResponse.Type;

@RestControllerAdvice
public class ExceptionHandlers {
	
	private final Map<Class<? extends AuthenticationException>, String> messages = new HashMap<>();
	
	{
		messages.put(UsernameNotFoundException.class, "Please check your login email.");
		messages.put(BadCredentialsException.class, "Please check your password.");
		messages.put(DisabledException.class, "Your account is disabled, please contact to admin team.");
		messages.put(LockedException.class, "Your account is locked, please contact to admin team.");
		messages.put(AccountExpiredException.class, "Your account is expired, please contact to admin team.");
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorResponse handle(AuthenticationException e) {
		var message = Optional.ofNullable(messages.get(e.getClass()));
		return new ErrorResponse(Type.Security, List.of(message.orElse("You have to authenticate for this operation.")));
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorResponse handle(AccessDeniedException e) {
		return new ErrorResponse(Type.Security, List.of("You have no permission for this operation."));
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handle(ApiValidationException e) {
		return ErrorResponse.of(e);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handle(ApiBusinessException e) {
		return ErrorResponse.of(e);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handle(Exception e) {
		return new ErrorResponse(Type.Platform, List.of(e.getMessage()));
	}
}
