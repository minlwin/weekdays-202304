package com.jdc.goldern.members.api;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CustomerEdit;
import com.jdc.goldern.members.model.dto.input.CustomerSearch;
import com.jdc.goldern.members.model.dto.output.CustomerDetails;
import com.jdc.goldern.members.model.dto.output.CustomerList;

public class EmployeeCustomerApi {

	public EmployeeCustomerApi() {
	}

	public PageResponse<CustomerList> search(CustomerSearch form) {
		// TODO implement here
		return null;
	}

	public CustomerDetails findById(long id) {
		// TODO implement here
		return null;
	}

	public CustomerDetails create(CustomerEdit form) {
		// TODO implement here
		return null;
	}

	public CustomerDetails update(long id, CustomerEdit form) {
		// TODO implement here
		return null;
	}

	public CustomerEdit findByIdForEdit(long id) {
		// TODO implement here
		return null;
	}

}