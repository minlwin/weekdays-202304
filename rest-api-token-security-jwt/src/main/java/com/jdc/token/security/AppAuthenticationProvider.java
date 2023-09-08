package com.jdc.token.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.token.model.repo.AccountRepo;

@Service
public class AppAuthenticationProvider extends DaoAuthenticationProvider {

	public AppAuthenticationProvider(PasswordEncoder passwordEncoder, AccountRepo repo) {
		super(passwordEncoder);
		setUserDetailsService(username -> repo.findOneByEmail(username)
				.map(a -> User.withUsername(username)
						.password(a.getPassword())
						.authorities(a.getRole().name())
						.build())
				.orElseThrow(() -> new UsernameNotFoundException(username))
		);
		setHideUserNotFoundExceptions(false);
	}
}
