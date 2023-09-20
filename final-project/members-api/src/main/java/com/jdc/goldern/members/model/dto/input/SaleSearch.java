package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SaleSearch {

	private Optional<Long> customerId;

	private Optional<String> nrcNumber;

	private Optional<String> name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Optional<LocalDate> dateFrom;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Optional<LocalDate> dateTo;

}