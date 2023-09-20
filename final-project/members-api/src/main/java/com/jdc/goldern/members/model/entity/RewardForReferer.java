package com.jdc.goldern.members.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.consts.RewardType;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(value = AuditingEntityListener.class)
public class RewardForReferer extends RewardTransaction{

	public RewardForReferer() {
		setRewardType(RewardType.Referer);
	}
	
	@OneToOne(optional = false)
	private Reward reward;	
}
