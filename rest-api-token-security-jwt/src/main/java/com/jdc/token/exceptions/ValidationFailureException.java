package com.jdc.token.exceptions;

import java.util.List;

import org.springframework.validation.BindingResult;

public class ValidationFailureException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private List<String> messages;
	
	public ValidationFailureException(BindingResult result) {
		messages = result.getFieldErrors().stream()
				.map(a -> a.getDefaultMessage()).toList();
	}
	
	public List<String> getMessages() {
		return messages;
	}
}
