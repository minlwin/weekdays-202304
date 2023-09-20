package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.goldern.members.model.entity.consts.RewardType;

import lombok.Data;

@Data
public class RewardList {

	private long id;

	private RewardType type;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime issueAt;

	private CustomerList customer;

	private BigDecimal amount;

}