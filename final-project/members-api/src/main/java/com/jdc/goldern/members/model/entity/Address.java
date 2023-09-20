package com.jdc.goldern.members.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "address_seq", allocationSize = 1)
public class Address {

	@Id
	@GeneratedValue(generator = "address_seq")
	private Long id;

	@OneToOne(optional = false)
	private Customer customer;

	@ManyToOne(optional = false)
	private Township township;

	@Column(nullable = false)
	private String address;

}