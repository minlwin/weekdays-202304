package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Account;
import com.jdc.goldern.members.model.entity.consts.Role;

import lombok.Data;

@Data
public class SignInResult {

	private long id;
	private String name;
	private String email;
	private Role role;
	private String token;
	
	public SignInResult account(Account account) {
		this.id = account.getId();
		this.name = account.getName();
		this.email = account.getEmail();
		this.role = account.getRole();
		return this;
	}
	
	public SignInResult token(String token) {
		this.token = token;
		return this;
	}

}