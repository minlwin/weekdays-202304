package com.jdc.goldern.members.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.goldern.members.model.entity.Account;
import com.jdc.goldern.members.model.repo.AccountRepo;
import com.jdc.goldern.members.model.utils.exceptions.ApiBusinessException;

@Service
public class AccountService {

	@Autowired
	private AccountRepo repo;
	
	@Transactional(readOnly = true)
	public Account findByEmail(String email) {
		return repo.findOneByEmail(email).orElseThrow(() -> new ApiBusinessException("There is no account with email [%s].".formatted(email)));
	}
}
