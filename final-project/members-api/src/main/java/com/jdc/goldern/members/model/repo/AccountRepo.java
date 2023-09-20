package com.jdc.goldern.members.model.repo;

import java.util.Optional;

import com.jdc.goldern.members.model.BaseRepository;
import com.jdc.goldern.members.model.entity.Account;

public interface AccountRepo extends BaseRepository<Account, Long>{

	Optional<Account> findOneByEmail(String email);
}