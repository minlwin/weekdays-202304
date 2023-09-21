package com.jdc.goldern.members.model.utils.exceptions;

import java.util.List;

import com.jdc.goldern.members.model.dto.ErrorResponse.Type;

public abstract class ApiBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Type type;
	private List<String> messages;

	public ApiBaseException(Type type, List<String> messages) {
		super("%s exception in api.".formatted(type.name()));
		this.type = type;
		this.messages = messages;
		
	}

	public Type getType() {
		return type;
	}

	public List<String> getMessages() {
		return messages;
	}

}
