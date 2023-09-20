package com.jdc.goldern.members.model.dto.input;

import com.jdc.goldern.members.model.entity.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryEdit {

	@NotBlank(message = "Please enter category name.")
	private String name;
	private boolean deleted;

	public Category entity() {
		var entity = new Category();
		entity.setName(name);
		entity.getAudit().setDeleted(deleted);
		return entity;
	}
}