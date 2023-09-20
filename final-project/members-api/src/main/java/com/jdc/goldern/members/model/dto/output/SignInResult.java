package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.consts.Role;

import lombok.Data;

@Data
public class SignInResult {

	private long id;

	private String name;

	private String email;

	private Role role;

	private String nrcNumber;

	private String remark;

}