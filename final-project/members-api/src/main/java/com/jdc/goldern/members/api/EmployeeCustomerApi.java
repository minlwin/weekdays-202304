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
import com.jdc.goldern.members.model.dto.input.CustomerEdit;
import com.jdc.goldern.members.model.dto.input.CustomerSearch;
import com.jdc.goldern.members.model.dto.output.CustomerDetails;
import com.jdc.goldern.members.model.dto.output.CustomerList;
import com.jdc.goldern.members.model.service.CustomerService;

@RestController
@RequestMapping("employee/customers")
public class EmployeeCustomerApi {
	
	@Autowired
	private CustomerService service;

	@GetMapping
	public PageResponse<CustomerList> search(CustomerSearch form,
			@RequestParam(defaultValue = "0") int page,  
			@RequestParam(defaultValue = "10") int max) {
		return service.search(form, page, max);
	}

	@GetMapping("{id}")
	public CustomerDetails findById(@PathVariable long id) {
		return service.findById(id);
	}
	
	@GetMapping("{id}/edit")
	public CustomerEdit findByIdForEdit(@PathVariable long id) {
		return service.findForEdit(id);
	}

	@PostMapping
	public CustomerDetails create(@Validated @RequestBody CustomerEdit form, BindingResult result) {
		return service.create(form);
	}

	@PutMapping("{id}")
	public CustomerDetails update(@PathVariable long id, @Validated @RequestBody CustomerEdit form, BindingResult result) {
		return service.update(id, form);
	}

}