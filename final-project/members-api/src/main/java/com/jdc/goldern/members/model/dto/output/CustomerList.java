package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CustomerList {

	private long id;

	private String name;

	private String phone;

	private String email;

	private String nrcNumber;

	private LocalDateTime registAt;

	private String remark;

	private boolean deleted;

}