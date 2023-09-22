package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleItemDto {

	private long id;

	private CatalogDto catalog;

	private BigDecimal salePrice;

}