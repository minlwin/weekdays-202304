package com.jdc.goldern.members.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.output.CustomerList;
import com.jdc.goldern.members.model.dto.output.ReferDetails;

@RestController
@RequestMapping("customer/refers")
public class CustomerReferApi {

	@GetMapping("{id}")
	public PageResponse<CustomerList> search(@PathVariable("id") long customerId) {
		// TODO implement here
		return null;
	}

	@GetMapping("{id}/details")
	public ReferDetails findById(@PathVariable long id) {
		// TODO implement here
		return null;
	}

}