package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jdc.goldern.members.model.entity.consts.TransactionType;
import com.jdc.goldern.members.model.entity.embedded.AuditInfo;

import lombok.Data;

@Data
public class Transaction {

	private long id;

	private Account account;

	private TransactionType type;

	private LocalDateTime issueAt;

	private BigDecimal lastAmount;

	private BigDecimal transactionAmount;

	private AuditInfo audit;

}