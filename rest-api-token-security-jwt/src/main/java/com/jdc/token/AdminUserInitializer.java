package com.jdc.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.token.model.entity.Account;
import com.jdc.token.model.entity.Account.Role;
import com.jdc.token.model.repo.AccountRepo;

@Configuration
public class AdminUserInitializer {
	
	@Autowired
	private AccountRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(classes = ContextRefreshedEvent.class)
	void initializeAdminUser() {
		if(repo.count() == 0L) {
			var admin = new Account();
			admin.setName("Admin User");
			admin.setEmail("admin@gmail.com");
			admin.setRole(Role.Admin);
			admin.setPassword(passwordEncoder.encode("admin"));
			
			repo.save(admin);
		}
	}
}
