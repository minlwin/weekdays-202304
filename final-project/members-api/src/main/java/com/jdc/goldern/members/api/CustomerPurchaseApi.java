package com.jdc.goldern.members.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.output.SaleList;

@RestController
@RequestMapping("customer/purchases")
public class CustomerPurchaseApi {

	@GetMapping("{id}")
	public PageResponse<SaleList> search(@PathVariable("id") long customerId) {
		// TODO implement here
		return null;
	}

}