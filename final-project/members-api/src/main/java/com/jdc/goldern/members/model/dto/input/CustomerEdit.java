package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;

import com.jdc.goldern.members.model.entity.consts.Gender;

import lombok.Data;

@Data
public class CustomerEdit {

	private String name;

	private String phone;

	private String email;

	private String nrcNumber;

	private Gender gender;

	private LocalDate dateOfBirth;

	private String address;

	private String township;

	private String remark;

	private Long refererId;

	private boolean deleted;

}