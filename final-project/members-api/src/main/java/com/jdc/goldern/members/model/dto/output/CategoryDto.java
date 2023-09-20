package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {

	private int id;
	private String name;
	
	public static CategoryDto from(Category entity) {
		return new CategoryDto(entity.getId(), entity.getName());
	}
}
