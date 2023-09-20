package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;

import com.jdc.goldern.members.model.entity.embedded.AuditInfo;

import lombok.Data;

@Data
public class GoldVault {

	private long id;

	private Account account;

	private BigDecimal currentAmount;

	private AuditInfo audit;

}