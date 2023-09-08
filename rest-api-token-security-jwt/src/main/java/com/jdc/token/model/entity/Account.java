package com.jdc.token.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_account", allocationSize = 1)
public class Account {

	@Id
	@GeneratedValue(generator = "seq_account")
	private int id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Role role;
	
	public enum Role {
		Admin, Member
	}
}
