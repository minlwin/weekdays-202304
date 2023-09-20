package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jdc.goldern.members.model.entity.consts.RewardType;

import lombok.Data;

@Data
public class RewardList {

	private long id;

	private RewardType type;

	private LocalDateTime issueAt;

	private CustomerList customer;

	private BigDecimal amount;

}