package com.jdc.goldern.members.model.dto.output;

import lombok.Data;

@Data
public class CustomerDetails {

	private CustomerList customer;

	private AddressDto address;


}