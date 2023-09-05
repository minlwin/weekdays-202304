package com.jdc.locations.api;

import java.util.List;
import java.util.Optional;

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

import com.jdc.locations.model.DivisionForm;
import com.jdc.locations.model.entity.Division;
import com.jdc.locations.model.service.DivisionService;

@RestController
@RequestMapping("divisions")
public class DivisionApi {
	
	@Autowired
	private DivisionService service;

	@GetMapping
	List<Division> search(
			@RequestParam Optional<String> region, 
			@RequestParam Optional<String> name) {
		return service.search(region, name);
	}
	
	@GetMapping("{id}")
	Division findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	Division create(@Validated @RequestBody DivisionForm form, BindingResult result) {
		return service.create(form);
	}
	
	@PutMapping("{id}")
	Division update(@PathVariable int id, @Validated @RequestBody DivisionForm form, BindingResult result) {
		return service.update(id, form);
	}
}
