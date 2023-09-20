package com.jdc.goldern.members.model.dto.input;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.jdc.goldern.members.model.entity.Customer;

import lombok.Data;

@Data
public class CustomerSearch {

	private Optional<Long> id;
	private Optional<String> name;
	private Optional<String> phone;
	private Optional<String> address;
	
	public Specification<Customer> where() {
		return null;
	}

}