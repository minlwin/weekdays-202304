package com.jdc.goldern.members.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.input.CategoryEdit;
import com.jdc.goldern.members.model.dto.output.CategoryList;
import com.jdc.goldern.members.model.service.CategoryService;

@RestController
@RequestMapping("employee/categories")
public class EmployeeCategoryApi {
	
	@Autowired
	private CategoryService service;

	@GetMapping
	public List<CategoryList> search() {
		return service.getAllForCompany();
	}

	@PostMapping
	public List<CategoryList> create(@Validated @RequestBody CategoryEdit form, BindingResult result) {
		return service.create(form);
	}

	@PutMapping("{id}")
	public List<CategoryList> update(@PathVariable int id, @Validated @RequestBody CategoryEdit form, BindingResult result) {
		return service.update(id, form);
	}

}