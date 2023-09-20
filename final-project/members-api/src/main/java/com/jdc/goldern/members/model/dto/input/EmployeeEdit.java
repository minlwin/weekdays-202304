package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.jdc.goldern.members.model.entity.consts.Role;

import lombok.Data;

@Data
public class EmployeeEdit {

	private String name;

	private String phone;

	private String email;

	private String nrcNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate assignDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate retireDate;

	private Role role;

	private String remark;

}