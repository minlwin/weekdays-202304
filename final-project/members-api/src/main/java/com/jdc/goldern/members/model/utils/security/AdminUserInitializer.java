package com.jdc.goldern.members.model.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.goldern.members.model.entity.Admin;
import com.jdc.goldern.members.model.entity.consts.Role;
import com.jdc.goldern.members.model.repo.AdminRepo;

@Configuration
@Transactional
public class AdminUserInitializer {

	@Autowired
	private AdminRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(classes = ContextRefreshedEvent.class)
	public void initUser() {
		
		if(repo.count() == 0L) {
			var admin = new Admin();
			admin.setName("Admin User");
			admin.setEmail("admin@gmail.com");
			admin.setRole(Role.Admin);
			admin.setNrcNumber("admin");
			admin.setPassword(passwordEncoder.encode("pass@123"));
			repo.save(admin);
		}
	}
}
