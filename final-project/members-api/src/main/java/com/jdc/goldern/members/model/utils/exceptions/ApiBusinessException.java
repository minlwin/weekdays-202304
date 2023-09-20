package com.jdc.goldern.members.model.utils.exceptions;

import java.util.List;

import com.jdc.goldern.members.model.dto.ErrorResponse.Type;

public class ApiBusinessException extends ApiBaseException{

	private static final long serialVersionUID = 1L;

	public ApiBusinessException(String message) {
		super(Type.Business, List.of(message));
	}
}
