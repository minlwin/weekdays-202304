package com.jdc.goldern.members.model.entity;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.consts.Role;
import com.jdc.goldern.members.model.entity.embedded.AuditingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "account_seq", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account extends AuditingEntity{

	@Id
	@GeneratedValue(generator = "account_seq")
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Role role;

	@Column(nullable = false)
	private String nrcNumber;

	private String remark;

	@OneToMany(mappedBy = "referer")
	private List<Customer> referes;

	@OneToOne(mappedBy = "account")
	private GoldVault vault;

}