package com.jdc.goldern.members.model.dto.input;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaleEdit {

	@NotNull(message = "Please select customer.")
	private Long customerId;

	@NotNull(message = "Please define sale employee.")
	private Long employeeId;

	@NotEmpty(message = "Please define sale items.")
	private List<SaleItemEdit> items;

}