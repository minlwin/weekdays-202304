package com.jdc.goldern.members.model.utils.exceptions;

import java.util.List;

import com.jdc.goldern.members.model.dto.ErrorResponse.Type;

public class ApiSecurityException extends ApiBaseException{

	private static final long serialVersionUID = 1L;

	public ApiSecurityException(String message) {
		super(Type.Security, List.of(message));
	}

}
