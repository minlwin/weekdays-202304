package com.jdc.goldern.members.model.entity;

import java.util.List;

import com.jdc.goldern.members.model.entity.consts.Role;
import com.jdc.goldern.members.model.entity.embedded.AuditInfo;

import lombok.Data;

@Data
public abstract class Account {

	private long id;

	private String name;

	private String email;

	private String password;

	private Role role;

	private String nrcNumber;

	private String remark;

	private AuditInfo audit;

	private List<Customer> referes;

	private GoldVault vault;

}