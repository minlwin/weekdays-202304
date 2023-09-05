package com.jdc.locations.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.locations.model.TownshipForm;
import com.jdc.locations.model.entity.Township;
import com.jdc.locations.model.service.TownshipService;

@RestController
@RequestMapping("townships")
public class TownshipApi {
	
	@Autowired
	private TownshipService service;

	@GetMapping
	List<Township> search(
			@RequestParam Optional<Integer> division,
			@RequestParam Optional<String> name
			) {
		return service.search(division, name);
	}
	
	@GetMapping("{id}")
	Township findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	Township create(@RequestBody TownshipForm form) {
		return service.create(form);
	}

	@PutMapping("{id}")
	Township update(@PathVariable int id, @RequestBody TownshipForm form) {
		return service.update(id, form);
	}
}
