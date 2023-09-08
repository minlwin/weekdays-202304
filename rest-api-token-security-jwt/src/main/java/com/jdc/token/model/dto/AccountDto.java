package com.jdc.token.model.dto;

import com.jdc.token.model.entity.Account;
import com.jdc.token.model.entity.Account.Role;

public record AccountDto(
		int id,
		String name,
		String email,
		Role role		
		) {

	public static AccountDto from(Account entity) {
		return new AccountDto(entity.getId(), 
				entity.getName(), 
				entity.getEmail(), 
				entity.getRole());
	}
}
