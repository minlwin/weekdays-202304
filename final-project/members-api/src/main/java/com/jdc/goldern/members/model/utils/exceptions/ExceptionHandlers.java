package com.jdc.goldern.members.model.utils.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.goldern.members.model.dto.ErrorResponse;
import com.jdc.goldern.members.model.dto.ErrorResponse.Type;

@RestControllerAdvice
public class ExceptionHandlers {

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
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorResponse handle(ApiSecurityException e) {
		return ErrorResponse.of(e);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handle(Exception e) {
		return new ErrorResponse(Type.Platform, List.of(e.getMessage()));
	}
}
