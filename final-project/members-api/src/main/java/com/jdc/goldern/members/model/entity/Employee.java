package com.jdc.goldern.members.model.entity;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends Account {

	public Employee() {
	}

	private LocalDate assignAt;

	private LocalDate retireAt;

}