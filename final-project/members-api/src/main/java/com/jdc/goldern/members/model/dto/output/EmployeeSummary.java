package com.jdc.goldern.members.model.dto.output;

import lombok.Data;

@Data
public class EmployeeSummary {

	private SaleSummary todaySales;

	private SaleSummary monthlySales;

	private SaleSummary yearlySales;

	private SaleSummary totalSales;

}