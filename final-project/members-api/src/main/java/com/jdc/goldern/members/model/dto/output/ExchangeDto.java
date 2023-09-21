package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ExchangeDto {

	private long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime issueAt;

	private BigDecimal lastAmount;

	private BigDecimal exchangeAmount;

	private BigDecimal remainAmount;

	private BigDecimal goldPrice;

	private BigDecimal exchangeInCash;

}