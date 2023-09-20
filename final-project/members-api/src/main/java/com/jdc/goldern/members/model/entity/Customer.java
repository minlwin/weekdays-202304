package com.jdc.goldern.members.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.jdc.goldern.members.model.entity.consts.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Customer extends Account {

	private Gender gender;

	private LocalDate dateOfBirth;

	@OneToOne(mappedBy = "customer")
	private Address address;

	@ManyToOne
	private Account referer;
	
	@OneToMany(mappedBy = "customer")
	private List<Sale> purchases;

}