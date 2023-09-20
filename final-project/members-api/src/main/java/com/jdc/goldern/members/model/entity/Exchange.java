package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;

import com.jdc.goldern.members.model.entity.consts.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Exchange extends Transaction {

	@Column(nullable = false)
	private BigDecimal goldPrice;

	public Exchange() {
		setType(TransactionType.Debit);
	}
}