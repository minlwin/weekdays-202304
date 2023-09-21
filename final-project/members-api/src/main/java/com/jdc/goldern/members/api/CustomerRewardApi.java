package com.jdc.goldern.members.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.output.RewardList;
import com.jdc.goldern.members.model.service.RewardService;

@RequestMapping("customer/rewards")
public class CustomerRewardApi {
	
	@Autowired
	private RewardService service;

	@GetMapping("{id}")
	public PageResponse<RewardList> search(@PathVariable("id") long customerId,
			@RequestParam(defaultValue = "0") int page,  
			@RequestParam(defaultValue = "10") int max) {
		return service.search(customerId, page, max);
	}

}