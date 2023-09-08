package com.jdc.token.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.token.model.dto.SignInResult;
import com.jdc.token.model.form.SignInForm;
import com.jdc.token.model.form.SignUpForm;
import com.jdc.token.model.service.AccountService;
import com.jdc.token.security.JwtTokenProvider;

@RestController
@RequestMapping("public")
public class SecurityApi {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AccountService accountService;

	@PostMapping("signin")
	SignInResult signIn(@Validated @RequestBody SignInForm form, BindingResult result) {
		return internalSignIn(form);
	}
	
	@PostMapping("signup")
	SignInResult signUp(@Validated @RequestBody SignUpForm form, BindingResult result) {
		
		// Create Account
		accountService.create(form);
		
		// Sign In
		return internalSignIn(new SignInForm(form.email(), form.password()));
	}
	
	private SignInResult internalSignIn(SignInForm form) {
		// Authenticate
		var authResult = authenticationManager.authenticate(form.authentication());
		
		// Generate Token
		var token = jwtTokenProvider.generate(authResult);
		
		// Create Result
		var account = accountService.findByUsername(authResult.getName());
		
		return SignInResult.from(account, token);
	}
}
