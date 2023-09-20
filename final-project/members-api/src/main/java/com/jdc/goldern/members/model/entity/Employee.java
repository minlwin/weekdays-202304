package com.jdc.goldern.members.model.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@EntityListeners(value = AuditingEntityListener.class)
public class Employee extends Account {

	@Column(nullable = false)
	private LocalDate assignAt;

	private LocalDate retireAt;
	
	@OneToMany(mappedBy = "employee")
	private List<Sale> sales;

}