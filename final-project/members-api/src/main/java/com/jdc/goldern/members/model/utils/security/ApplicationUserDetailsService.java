package com.jdc.goldern.members.model.utils.security;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.goldern.members.model.entity.Account;
import com.jdc.goldern.members.model.entity.Customer;
import com.jdc.goldern.members.model.entity.Employee;
import com.jdc.goldern.members.model.entity.consts.Role;
import com.jdc.goldern.members.model.repo.AccountRepo;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{

	@Autowired
	private AccountRepo repo;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findOneByEmail(username).map(this::accountToUser)
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}
	
	private UserDetails accountToUser(Account account) {
		return account instanceof Customer ? customerToUser(account) : employeeToUser(account);
	}
	
	private UserDetails customerToUser(Account acc) {
		if(acc instanceof Customer cust) {
			return User.builder()
					.username(acc.getEmail())
					.password(acc.getPassword())
					.roles(acc.getRole().getValue())
					.disabled(cust.getRegisterAt().isBefore(LocalDate.now()))
					.accountLocked(acc.getAudit().isDeleted())
					.build();
		}
		throw new UsernameNotFoundException(acc.getEmail());
	}
	
	private UserDetails employeeToUser(Account acc) {
		if(acc instanceof Employee employee) {
			return User.builder()
					.username(acc.getEmail())
					.password(acc.getPassword())
					.roles(acc.getRole().getValue())
					.disabled(employee.getAssignAt().isAfter(LocalDate.now()))
					.accountExpired(null !=  employee.getRetireAt() && employee.getRetireAt().isBefore(LocalDate.now()))
					.accountLocked(acc.getAudit().isDeleted())
					.build();
		} 
		
		if(acc.getRole() == Role.Admin) {
			return User.builder()
					.username(acc.getEmail())
					.password(acc.getPassword())
					.roles(acc.getRole().getValue())
					.build();
		}
		
		throw new UsernameNotFoundException(acc.getEmail());
	}
}
