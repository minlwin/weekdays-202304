package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeeList {

	private long id;

	private String name;

	private String phone;

	private String email;

	private String nrcNumber;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime assignAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime retireAt;

	private String remark;

	private boolean deleted;
}