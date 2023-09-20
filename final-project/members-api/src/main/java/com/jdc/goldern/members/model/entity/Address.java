package com.jdc.goldern.members.model.entity;

import lombok.Data;

@Data
public class Address {

	private Long id;

	private Customer customer;

	private Township township;

	private String address;

}