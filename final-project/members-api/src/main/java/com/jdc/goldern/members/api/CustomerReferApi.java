package com.jdc.goldern.members.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.output.CustomerList;
import com.jdc.goldern.members.model.dto.output.ReferDetails;
import com.jdc.goldern.members.model.service.ReferService;

@RestController
@RequestMapping("customer/refers")
public class CustomerReferApi {
	
	@Autowired
	private ReferService service;

	@GetMapping("{id}")
	public PageResponse<CustomerList> search(@PathVariable("id") long customerId, 
			@RequestParam(defaultValue = "0") int page,  
			@RequestParam(defaultValue = "10") int max) {
		return service.search(customerId, page, max);
	}

	@GetMapping("{id}/details")
	public ReferDetails findById(@PathVariable long id) {
		return service.findById(id);
	}

}