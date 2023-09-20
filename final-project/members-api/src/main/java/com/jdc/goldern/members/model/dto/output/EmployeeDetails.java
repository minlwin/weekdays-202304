package com.jdc.goldern.members.model.dto.output;

import lombok.Data;

@Data
public class EmployeeDetails {

	private EmployeeList employee;
	private SaleSummary dailySales;
	private SaleSummary montnlySales;
	private SaleSummary yearlySales;
	private SaleSummary totalSales;
	
}