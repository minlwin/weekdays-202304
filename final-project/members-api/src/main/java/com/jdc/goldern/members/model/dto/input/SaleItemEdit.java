package com.jdc.goldern.members.model.dto.input;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleItemEdit {

	private int catalogId;

	private int quantity;

	private BigDecimal customerReward;

	private BigDecimal refererReward;

}