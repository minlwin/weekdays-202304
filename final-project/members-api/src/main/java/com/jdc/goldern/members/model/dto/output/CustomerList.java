package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CustomerList {

	private long id;

	private String name;

	private String phone;

	private String email;

	private String nrcNumber;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime registAt;

	private String remark;

	private boolean deleted;

}