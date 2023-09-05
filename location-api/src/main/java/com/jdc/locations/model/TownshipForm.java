package com.jdc.locations.model;

import java.util.function.Function;

import com.jdc.locations.model.entity.Division;
import com.jdc.locations.model.entity.Township;

public record TownshipForm(
		String name,
		int divisionId
		) {

	public Township entity(Function<Integer, Division> divisionFinder) {
		var entity = new Township();
		entity.setName(name);
		entity.setDivision(divisionFinder.apply(divisionId));
		return entity;
	}
}
