package com.jdc.goldern.members.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.output.SaleList;
import com.jdc.goldern.members.model.service.SaleService;

@RestController
@RequestMapping("customer/purchases")
public class CustomerPurchaseApi {
	
	@Autowired
	private SaleService service;

	@GetMapping("{id}")
	public PageResponse<SaleList> search(
			@PathVariable("id") long customerId,
			@RequestParam(defaultValue = "0") int page,  
			@RequestParam(defaultValue = "10") int max) {
		return service.searchForCustomer(customerId, page, max);
	}

}