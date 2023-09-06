package com.jdc.token.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
			@RequestParam String username, 
			@RequestParam String password) {
		
		// create authentication for authentication process
		var authentication = UsernamePasswordAuthenticationToken
				.unauthenticated(username, password);
		
		var result = authenticationManager.authenticate(authentication);
		SecurityContextHolder.getContext().setAuthentication(result);
		
		var token = tokenProvider.generate(result);
		
		if(null != token) {
			return new LoginResult(true, token);
		}
		
		return new LoginResult(false, "Authentication Failure");
	}
}
