package com.jdc.goldern.members.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.output.CustomerSummary;

@RestController
@RequestMapping("customer/home")
public class CustomerHomeApi {

	@GetMapping
	public CustomerSummary getSummary() {
		// TODO implement here
		return null;
	}

}