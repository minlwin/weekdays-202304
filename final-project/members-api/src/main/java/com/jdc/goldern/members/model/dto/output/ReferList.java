package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReferList {

	private long id;

	private String name;

	private LocalDateTime issueAt;

	private String division;

	private String township;

	private BigDecimal totalReward;

}