package com.jdc.goldern.members.model.entity;

import com.jdc.goldern.members.model.entity.consts.RewardType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RewardTransaction extends Transaction {

	private RewardType rewardType;

}