package com.jdc.goldern.members.model.entity.consts;

public enum Role {
	Customer,
	Employee,
	Manager,
	Owner,
	Admin;
	
	public String getValue() {
		return "ROLE_%s".formatted(name().toUpperCase());
	}
}