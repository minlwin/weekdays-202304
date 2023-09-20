package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Category;

public record CategoryList(
	int id,
	String name,
	long items
) {
	
	public static CategoryList from(Category entity) {
		return new CategoryList(entity.getId(), entity.getName(), entity.getCatalogs().size());
	}
}