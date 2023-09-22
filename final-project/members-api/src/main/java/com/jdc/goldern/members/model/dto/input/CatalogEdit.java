package com.jdc.goldern.members.model.dto.input;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.jdc.goldern.members.model.entity.Catalog;
import com.jdc.goldern.members.model.entity.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CatalogEdit {

	@NotBlank(message = "Please enter catalog name.")
	private String name;

	@NotEmpty(message = "Please select category for catalog.")
	private List<Integer> categories = new ArrayList<>();

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

	public Catalog entity(Function<Integer, Category> catagoryFinder) {
		var entity = new Catalog();
		entity.setName(name);
		entity.setCategories(categories.stream().map(catagoryFinder).toList());
		entity.setDescription(description);
		entity.setWeight(weight);
		entity.setPurity(purity);
		entity.setGoldSmithFees(goldSmithFees);
		entity.setLostWeight(lostWeight);
		entity.setPrice(price);
		return entity;
	}

}