package com.jdc.goldern.members.model.utils.exceptions;

import java.util.List;

import com.jdc.goldern.members.model.dto.ErrorResponse.Type;

public class ApiValidationException extends ApiBaseException{

	private static final long serialVersionUID = 1L;

	public ApiValidationException(List<String> messages) {
		super(Type.Validation, messages);
	}

}
