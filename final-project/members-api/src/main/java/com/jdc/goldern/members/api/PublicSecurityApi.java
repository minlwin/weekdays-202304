package com.jdc.goldern.members.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.input.SignInForm;
import com.jdc.goldern.members.model.dto.output.SignInResult;
import com.jdc.goldern.members.model.service.AccountService;
import com.jdc.goldern.members.model.utils.security.JwtTokenProvider;

@RestController
@RequestMapping("public/signin")
public class PublicSecurityApi {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AccountService accountService;

	@PostMapping
	public SignInResult signIn(@RequestBody SignInForm form, BindingResult result) {
		var auth = authenticationManager.authenticate(form.authentication());
		var token = jwtTokenProvider.generate(auth);
		return new SignInResult().token(token)
				.account(accountService.findByEmail(form.getEmail()));
	}

}