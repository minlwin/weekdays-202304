package com.jdc.goldern.members.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.output.RewardList;

@RequestMapping("customer/rewards")
public class CustomerRewardApi {

	@GetMapping("{id}")
	public PageResponse<RewardList> search(@PathVariable("id") long customerId) {
		// TODO implement here
		return null;
	}

}