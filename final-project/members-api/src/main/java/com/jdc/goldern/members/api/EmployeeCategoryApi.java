package com.jdc.goldern.members.api;

import java.util.List;

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

@RestController
@RequestMapping("employee/categories")
public class EmployeeCategoryApi {

	@GetMapping
	public List<CategoryList> search() {
		// TODO implement here
		return null;
	}

	@PostMapping
	public List<CategoryList> create(@Validated @RequestBody CategoryEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

	@PutMapping("{id}")
	public List<CategoryList> update(@PathVariable int id, @Validated @RequestBody CategoryEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

}