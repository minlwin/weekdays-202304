package com.jdc.goldern.members.model.dto.input;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInForm {

	@NotBlank(message = "Please enter login email.")
	private String email;
	@NotBlank(message = "Please enter login password.")
	private String password;

	public Authentication authentication() {
		return UsernamePasswordAuthenticationToken.unauthenticated(email, password);
	}
}