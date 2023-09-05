package com.jdc.locations.model;

import com.jdc.locations.model.entity.Division;

import jakarta.validation.constraints.NotEmpty;

public record DivisionForm(
		@NotEmpty(message = "Please enter division name.")
		String name,
		@NotEmpty(message = "Please enter region of division.")
		String region
		) {

	public Division entity() {
		var entity = new Division();
		entity.setName(name);
		entity.setRegion(region);
		return entity;
	}
}
