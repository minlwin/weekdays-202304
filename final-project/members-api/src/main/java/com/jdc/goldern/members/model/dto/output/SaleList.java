package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SaleList {

	private long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime issueAt;

	private CustomerDetails customer;

	private long items;

	private BigDecimal totalPrice;

	private BigDecimal totalLostWeight;

	private BigDecimal totalGoldSmithFees;

	private BigDecimal totalReward;

}