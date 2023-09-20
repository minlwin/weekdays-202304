package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Exchange extends Transaction {

	private BigDecimal goldPrice;

}