package com.jdc.goldern.members.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.output.DivisionDto;
import com.jdc.goldern.members.model.dto.output.TownshipDto;
import com.jdc.goldern.members.model.service.LocationService;


@RestController
@RequestMapping("public/locations")
public class PublicLocationApi {
	
	@Autowired
	private LocationService service;

	@GetMapping("divisions")
	public List<DivisionDto> divisions() {
		return service.getAllDivisions();
	}

	@GetMapping("townships")
	public List<TownshipDto> townships(@RequestParam Optional<Integer> division) {
		return service.searchTownship(division);
	}
}
