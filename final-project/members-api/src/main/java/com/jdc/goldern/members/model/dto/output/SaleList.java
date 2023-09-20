package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SaleList {

	private long id;

	private LocalDateTime issueAt;

	private CustomerDetails customer;

	private long items;

	private BigDecimal totalPrice;

	private BigDecimal totalLostWeight;

	private BigDecimal totalGoldSmithFees;

	private BigDecimal totalReward;

}