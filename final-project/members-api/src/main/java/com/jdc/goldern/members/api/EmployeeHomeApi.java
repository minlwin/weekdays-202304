package com.jdc.goldern.members.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.output.EmployeeSummary;

@RestController
@RequestMapping("employee/home")
public class EmployeeHomeApi {

	@GetMapping
	public EmployeeSummary getSummary() {
		// TODO implement here
		return null;
	}

}