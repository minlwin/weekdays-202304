package com.jdc.locations.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.locations.exceptions.LocationAppException.Type;
import com.jdc.locations.model.ErrorResponse;

@RestControllerAdvice
public class CommonExceptionHandlers {

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	ErrorResponse handle(LocationAppException e) {
		return new ErrorResponse(Type.Business, e.getMessages());
	}
	
}
