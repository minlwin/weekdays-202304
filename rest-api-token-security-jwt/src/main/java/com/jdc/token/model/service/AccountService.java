package com.jdc.token.model.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.token.model.dto.AccountDto;
import com.jdc.token.model.form.SignUpForm;
import com.jdc.token.model.repo.AccountRepo;

@Service
@Transactional(readOnly = true)
public class AccountService {
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public AccountDto findByUsername(String name) {
		return accountRepo.findOneByEmail(name)
				.map(AccountDto::from)
				.orElseThrow(() -> new NoSuchElementException("There is no account with email %s.".formatted(name)));
	}

	@Transactional
	public AccountDto create(SignUpForm form) {
		var entity = accountRepo.save(form.entity(passwordEncoder));
		return AccountDto.from(entity);
	}

}
