package com.jdc.goldern.members.model.dto.input;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CatalogEdit {

	@NotBlank(message = "Please enter catalog name.")
	private String name;

	@NotEmpty(message = "Please select category for catalog.")
	private List<Integer> categories;

	@NotBlank(message = "Please enter catalog description.")
	private String description;

	@NotNull(message = "Please enter weight.")
	private BigDecimal weight;

	@NotNull(message = "Please enter purity.")
	private BigDecimal purity;

	@NotNull(message = "Please enter gold smith fees.")
	private BigDecimal goldSmithFees;

	@NotNull(message = "Please enter lost weight.")
	private BigDecimal lostWeight;

	@NotNull(message = "Please enter price.")
	private BigDecimal price;

}