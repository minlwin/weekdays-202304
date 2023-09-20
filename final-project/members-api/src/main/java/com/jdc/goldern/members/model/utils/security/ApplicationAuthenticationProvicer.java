package com.jdc.goldern.members.model.utils.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationAuthenticationProvicer extends DaoAuthenticationProvider{

	public ApplicationAuthenticationProvicer(ApplicationUserDetailsService applicationUserDetailsService, PasswordEncoder passwordEncoder) {
		setHideUserNotFoundExceptions(false);
		setUserDetailsService(applicationUserDetailsService);
		setPasswordEncoder(passwordEncoder);
	}
}
