package com.jdc.token.model.form;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.token.model.entity.Account;
import com.jdc.token.model.entity.Account.Role;

import jakarta.validation.constraints.NotBlank;

public record SignUpForm(
		@NotBlank(message = "Please enter user name.")
		String name,
		@NotBlank(message = "Please enter login email.")
		String email,
		@NotBlank(message = "Please enter password.")
		String password		
		) {

	public Account entity(PasswordEncoder passwordEncoder) {
		var entity = new Account();
		entity.setName(name);
		entity.setEmail(email);
		entity.setRole(Role.Member);
		entity.setPassword(passwordEncoder.encode(password));
		return entity;
	}

}
