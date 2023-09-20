package com.jdc.goldern.members.model.dto.input;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaleItemEdit {

	@NotNull(message = "Please select catalog.")
	private Integer catalogId;

	@NotNull(message = "Please select quantity.")
	private Integer quantity;

	private BigDecimal customerReward;

	private BigDecimal refererReward;

}