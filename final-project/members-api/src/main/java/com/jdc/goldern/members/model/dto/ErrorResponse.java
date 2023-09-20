package com.jdc.goldern.members.model.dto;

import java.util.List;

import com.jdc.goldern.members.model.utils.exceptions.ApiBaseException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	
	private Type type;
	private List<String> messages;

	public enum Type {
		Validation, Business, Security, Platform
	}
	
	public static ErrorResponse of(ApiBaseException e) {
		return new ErrorResponse(e.getType(), e.getMessages());
	}
}
