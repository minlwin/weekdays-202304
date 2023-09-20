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
import com.jdc.goldern.members.model.dto.input.CustomerEdit;
import com.jdc.goldern.members.model.dto.input.CustomerSearch;
import com.jdc.goldern.members.model.dto.output.CustomerDetails;
import com.jdc.goldern.members.model.dto.output.CustomerList;

@RestController
@RequestMapping("employee/customers")
public class EmployeeCustomerApi {

	@GetMapping
	public PageResponse<CustomerList> search(CustomerSearch form) {
		// TODO implement here
		return null;
	}

	@GetMapping("{id}")
	public CustomerDetails findById(@PathVariable long id) {
		// TODO implement here
		return null;
	}
	
	@GetMapping("{id}/edit")
	public CustomerEdit findByIdForEdit(long id) {
		// TODO implement here
		return null;
	}

	@PostMapping
	public CustomerDetails create(@Validated @RequestBody CustomerEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

	@PutMapping("{id}")
	public CustomerDetails update(@PathVariable long id, @Validated @RequestBody CustomerEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

}