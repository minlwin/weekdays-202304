package com.jdc.locations.model;

import java.util.List;

import com.jdc.locations.exceptions.LocationAppException.Type;

public record ErrorResponse(
		Type type,
		List<String> messages
		) {

}
