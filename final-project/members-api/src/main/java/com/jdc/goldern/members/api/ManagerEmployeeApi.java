package com.jdc.goldern.members.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.EmployeeEdit;
import com.jdc.goldern.members.model.dto.input.EmployeeSearch;
import com.jdc.goldern.members.model.dto.output.EmployeeDetails;
import com.jdc.goldern.members.model.dto.output.EmployeeList;

@RestController
@RequestMapping("manager/employees")
public class ManagerEmployeeApi {

	@GetMapping
	public PageResponse<EmployeeList> search(EmployeeSearch form) {
		// TODO implement here
		return null;
	}

	@GetMapping("{id}")
	public EmployeeDetails findById(@PathVariable int id) {
		// TODO implement here
		return null;
	}

	@GetMapping("{id}/edit")
	public EmployeeEdit findByIdForEdit(@PathVariable int id) {
		// TODO implement here
		return null;
	}

	@PostMapping
	public EmployeeDetails create(@Validated @RequestBody EmployeeEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

	@PutMapping("{id}")
	public EmployeeDetails update(@PathVariable int id, @Validated @RequestBody EmployeeEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

}