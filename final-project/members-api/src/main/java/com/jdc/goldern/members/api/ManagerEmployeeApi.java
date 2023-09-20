package com.jdc.goldern.members.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.EmployeeEdit;
import com.jdc.goldern.members.model.dto.input.EmployeeSearch;
import com.jdc.goldern.members.model.dto.output.EmployeeDetails;
import com.jdc.goldern.members.model.dto.output.EmployeeDto;
import com.jdc.goldern.members.model.service.EmployeeService;

@RestController
@RequestMapping("manager/employees")
public class ManagerEmployeeApi {
	
	@Autowired
	private EmployeeService service;

	@GetMapping
	public PageResponse<EmployeeDto> search(EmployeeSearch form,
			@RequestParam(defaultValue = "1") int page,  
			@RequestParam(defaultValue = "10") int max) {
		return service.search(form, page, max);
	}

	@GetMapping("{id}")
	public EmployeeDetails findById(@PathVariable long id) {
		return service.findById(id);
	}

	@GetMapping("{id}/edit")
	public EmployeeEdit findByIdForEdit(@PathVariable long id) {
		return service.findForEdit(id);
	}

	@PostMapping
	public EmployeeDetails create(@Validated @RequestBody EmployeeEdit form, BindingResult result) {
		return service.create(form);
	}

	@PutMapping("{id}")
	public EmployeeDetails update(@PathVariable long id, @Validated @RequestBody EmployeeEdit form, BindingResult result) {
		return service.update(id, form);
	}

}