package com.jdc.demo.model.dto;

public record LoginUser(
	int id, String loginId, String name, String role) {

	public boolean hasRole(String role) {
		return this.role.equals(role);
	}
}
