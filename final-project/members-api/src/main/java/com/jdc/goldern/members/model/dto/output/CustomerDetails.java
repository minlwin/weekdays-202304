package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Customer;

import lombok.Data;

@Data
public class CustomerDetails {

	private CustomerList customer;

	private AddressDto address;
	
	
	public CustomerDetails(Customer entity) {
		this.customer = CustomerList.from(entity);
		
		address = new AddressDto();
		address.setId(entity.getAddress().getId());
		address.setAddress(entity.getAddress().getAddress());
		address.setTownship(entity.getAddress().getTownship().getName());
		address.setDivision(entity.getAddress().getTownship().getDivision().getName());
	}
	
}