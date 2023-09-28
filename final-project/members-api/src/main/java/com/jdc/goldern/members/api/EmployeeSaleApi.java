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
import com.jdc.goldern.members.model.dto.input.SaleEdit;
import com.jdc.goldern.members.model.dto.input.SaleSearch;
import com.jdc.goldern.members.model.dto.output.SaleDetails;
import com.jdc.goldern.members.model.dto.output.SaleList;
import com.jdc.goldern.members.model.service.SaleService;

@RestController
@RequestMapping("employee/sales")
public class EmployeeSaleApi {
	
	@Autowired
	private SaleService service;

	@GetMapping
	public PageResponse<SaleList> search(SaleSearch form,
			@RequestParam(defaultValue = "0") int page,  
			@RequestParam(defaultValue = "10") int max) {
		return service.searchForEmployee(form, page, max);
	}

	@GetMapping("{id}")
	public SaleDetails findById(@PathVariable long id) {
		return service.findDetails(id);
	}

	@PostMapping
	public SaleDetails create(@Validated @RequestBody SaleEdit form, BindingResult result) {
		return service.create(form);
	}
	
	@PutMapping("{id}")
	public SaleDetails update(@PathVariable long id, @Validated @RequestBody SaleEdit form, BindingResult result) {
		return service.update(id, form);
	}

	@PutMapping("{id}/edit")
	public SaleEdit findByIdForEdit(@PathVariable long id) {
		return service.findForEdit(id);
	}

}