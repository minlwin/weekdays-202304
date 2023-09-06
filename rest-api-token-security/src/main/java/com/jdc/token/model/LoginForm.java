package com.jdc.token.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(
		@NotBlank(message = "Enter login id.")
		String username, 
		@NotBlank(message = "Enter password.")
		String password
		) {

	public Authentication authentication() {
		return UsernamePasswordAuthenticationToken.unauthenticated(username, password);
	}

}
