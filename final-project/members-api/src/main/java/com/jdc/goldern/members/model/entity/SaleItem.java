package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleItem {

	private long id;

	private Sale sale;

	private Catalog catalog;

	private BigDecimal salePrice;

}