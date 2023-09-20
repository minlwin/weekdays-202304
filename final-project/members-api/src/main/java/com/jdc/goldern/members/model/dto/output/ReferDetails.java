package com.jdc.goldern.members.model.dto.output;

import java.util.List;

import lombok.Data;

@Data
public class ReferDetails {

	private ReferList refer;

	private List<RewardList> rewards;

}