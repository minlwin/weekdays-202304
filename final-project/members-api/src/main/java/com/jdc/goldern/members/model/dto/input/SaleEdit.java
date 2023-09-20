package com.jdc.goldern.members.model.dto.input;

import java.util.List;

import lombok.Data;

@Data
public class SaleEdit {

	private Long customerId;

	private Long employeeId;

	private Long refererId;

	private List<SaleItemEdit> items;

}