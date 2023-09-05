package com.jdc.locations.api;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("townships")
public class TownshipApi {

	@GetMapping
	List<Township> search(
			@RequestParam Optional<Integer> division,
			@RequestParam Optional<String> name
			) {
		return null;
	}
	
	@GetMapping("{id}")
	Township findById(@PathVariable int id) {
		return null;
	}
	
	@PostMapping
	Township create(@RequestBody TownshipForm form) {
		return null;
	}

	@PutMapping("{id}")
	Township update(@PathVariable int id, @RequestBody TownshipForm form) {
		return null;
	}
}
