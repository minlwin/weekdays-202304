package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EmployeeList {

	private long id;

	private String name;

	private String phone;

	private String email;

	private String nrcNumber;

	private LocalDateTime assignAt;
	private LocalDateTime retireAt;

	private String remark;

	private boolean deleted;
}