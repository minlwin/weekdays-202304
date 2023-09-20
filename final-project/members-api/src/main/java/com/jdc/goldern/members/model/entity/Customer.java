package com.jdc.goldern.members.model.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.consts.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = AuditingEntityListener.class)
public class Customer extends Account {

	private Gender gender;

	private LocalDate dateOfBirth;
	
	@Column(nullable = false)
	private LocalDate registerAt;

	@OneToOne(mappedBy = "customer")
	private Address address;

	@ManyToOne
	private Account referer;
	
	@OneToMany(mappedBy = "customer")
	private List<Sale> purchases;

}