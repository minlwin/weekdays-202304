package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Customer;

import lombok.Data;

@Data
public class CustomerDetails {

	private CustomerList customer;

	private AddressDto address;
	
	
	public CustomerDetails(Customer entity) {
		
	}
	
}