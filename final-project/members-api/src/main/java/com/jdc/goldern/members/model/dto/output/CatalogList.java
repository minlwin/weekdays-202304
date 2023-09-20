package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CatalogList {

	private int id;

	private String name;

	private BigDecimal price;

	private BigDecimal weight;

	private int raiting;

	private boolean isNew;

	private boolean isPopular;

	private String coverImage;

	private String description;

	private BigDecimal goldSmithFees;

	private BigDecimal lostWeight;

}