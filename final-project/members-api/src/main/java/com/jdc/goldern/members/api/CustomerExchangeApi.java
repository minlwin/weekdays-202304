package com.jdc.goldern.members.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.output.ExchangeList;

@RestController
@RequestMapping("customer/exchanges")
public class CustomerExchangeApi {

	@GetMapping("id")
	public PageResponse<ExchangeList> search(@PathVariable("id") long customerId) {
		// TODO implement here
		return null;
	}

	@GetMapping("{id}/details")
	public ExchangeList findById(@PathVariable long id) {
		// TODO implement here
		return null;
	}

}