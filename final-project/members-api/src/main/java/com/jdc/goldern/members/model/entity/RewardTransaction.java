package com.jdc.goldern.members.model.entity;

import com.jdc.goldern.members.model.entity.consts.RewardType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public abstract class RewardTransaction extends Transaction {

	@Column(nullable = false)
	private RewardType rewardType;
	
}