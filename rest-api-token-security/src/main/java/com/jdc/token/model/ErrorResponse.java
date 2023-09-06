package com.jdc.token.model;

import java.util.List;

public record ErrorResponse(
		Type type,
		List<String> messages
		) {

	public enum Type {
		Authentication, 
		Authorization, 
		Validation, 
		Business, 
		Platform
	}
}
