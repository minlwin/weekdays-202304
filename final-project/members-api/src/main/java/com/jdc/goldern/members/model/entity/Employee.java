package com.jdc.goldern.members.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Employee extends Account {

	private LocalDate assignAt;

	private LocalDate retireAt;
	
	@OneToMany(mappedBy = "employee")
	private List<Sale> sales;

}