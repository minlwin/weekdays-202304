package com.jdc.goldern.members.model.entity;

import com.jdc.goldern.members.model.entity.consts.RewardType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class RewardForReferer extends RewardTransaction{

	public RewardForReferer() {
		setRewardType(RewardType.Referer);
	}
	
	@OneToOne(optional = false)
	private Reward reward;	
}
