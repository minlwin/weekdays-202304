package com.jdc.goldern.members.model.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewForm {

	private int rating;
	
	@NotBlank(message = "Please enter review comment.")
	private String comment;

}
