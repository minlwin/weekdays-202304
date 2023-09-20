package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExchangeList {

	private long id;

	private LocalDateTime issueAt;

	private BigDecimal lastAmount;

	private BigDecimal exchangeAmount;

	private BigDecimal remainAmount;

	private BigDecimal goldPrice;

	private BigDecimal exchangeInCash;

}