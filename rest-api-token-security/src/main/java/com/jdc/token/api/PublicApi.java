package com.jdc.token.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.token.model.LoginForm;
import com.jdc.token.model.LoginResult;
import com.jdc.token.service.TokenProvider;

@RestController
@RequestMapping("public")
public class PublicApi {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenProvider tokenProvider;

	@PostMapping("login")
	LoginResult login(
			@Validated LoginForm form, BindingResult result) {
		
		var authentication = authenticationManager.authenticate(form.authentication());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		var token = tokenProvider.generate(authentication);
		
		if(null != token) {
			return new LoginResult(true, token);
		}
		
		return new LoginResult(false, "Authentication Failure");
	}
}
