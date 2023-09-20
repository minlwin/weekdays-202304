package com.jdc.goldern.members.model.entity;

import com.jdc.goldern.members.model.entity.consts.RewardType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class RewardForCustomer extends RewardTransaction{

	public RewardForCustomer() {
		setRewardType(RewardType.Customer);
	}
	
	@OneToOne(optional = false)
	private Reward reward;	
}
