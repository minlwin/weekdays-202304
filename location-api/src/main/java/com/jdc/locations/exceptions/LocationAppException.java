package com.jdc.locations.exceptions;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LocationAppException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final Type type;
	private final List<String> messages;
	
	public enum Type {
		Validation, Business, Platform
	}

}
