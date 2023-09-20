package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.jdc.goldern.members.model.entity.embedded.AuditInfo;

import lombok.Data;

@Data
public class Sale {

	private long id;

	private LocalDateTime issueAt;

	private Customer customer;

	private Reward reward;

	private List<SaleItem> items;

	private BigDecimal totalPrice;

	private BigDecimal totalLostWeight;

	private BigDecimal totalGoldSmithFees;

	private AuditInfo audit;

}