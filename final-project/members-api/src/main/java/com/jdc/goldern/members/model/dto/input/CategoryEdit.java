package com.jdc.goldern.members.model.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryEdit {

	@NotBlank(message = "Please enter category name.")
	private String name;

	private boolean deleted;

}