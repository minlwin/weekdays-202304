package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Employee;

import lombok.Data;

@Data
public class EmployeeDetails {

	private EmployeeDto employee;
	private SaleSummary dailySales;
	private SaleSummary montnlySales;
	private SaleSummary yearlySales;
	private SaleSummary totalSales;
	
	public EmployeeDetails(Employee entity) {
		employee = EmployeeDto.from(entity);
		// TODO need to define summary informations
	}
	
}