package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;
import java.util.Optional;

import lombok.Data;

@Data
public class SaleSearch {

	private Optional<Long> customerId;

	private Optional<String> nrcNumber;

	private Optional<String> name;

	private Optional<LocalDate> dateFrom;

	private Optional<LocalDate> dateTo;

}