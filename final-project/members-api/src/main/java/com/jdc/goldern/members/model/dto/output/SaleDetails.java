package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class SaleDetails {

	private long id;

	private CustomerDetails customer;

	private SaleList sale;

	private BigDecimal customerReward;

	private BigDecimal refererReward;

	private List<SaleItemDto> items;

}