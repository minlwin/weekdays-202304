package com.jdc.goldern.members.model.dto.input;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class CatalogEdit {

	private String name;

	private List<Integer> categories;

	private String description;

	private BigDecimal weight;

	private BigDecimal purity;

	private BigDecimal goldSmithFees;

	private BigDecimal lostWeight;

	private BigDecimal price;

}