package com.jdc.goldern.members.model.entity;

import com.jdc.goldern.members.model.entity.embedded.AuditInfo;

import lombok.Data;

@Data
public class Reward {

	private long id;

	private Sale sale;

	private RewardTransaction customerReward;

	private RewardTransaction refererReward;

	private AuditInfo audit;

}