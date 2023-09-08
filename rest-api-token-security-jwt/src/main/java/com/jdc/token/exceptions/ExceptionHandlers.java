package com.jdc.token.exceptions;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.token.model.dto.ErrorResult;
import com.jdc.token.model.dto.ErrorResult.Type;

@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorResult handle(ValidationFailureException e) {
		return new ErrorResult(Type.Validation, e.getMessages());
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ErrorResult handle(NoSuchElementException e) {
		return new ErrorResult(Type.Business, List.of(e.getMessage()));
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.FORBIDDEN)
	ErrorResult handle(AccessDeniedException e) {
		return new ErrorResult(Type.Authorization, List.of(e.getMessage()));
	}
	
	
}
