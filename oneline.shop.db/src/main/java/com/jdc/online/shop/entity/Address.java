package com.jdc.online.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(name = "ADDRESS_SEQ")
public class Address {

	@Id
	@GeneratedValue(generator = "ADDRESS_SEQ")
	private int id;
	
	@ManyToOne(optional = false)
	private Customer customer;
	
	@Column(nullable = false)
	private String building;
	@Column(nullable = false)
	private String street;
	@Column(nullable = false)
	private String townships;

}