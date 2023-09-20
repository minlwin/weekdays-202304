package com.jdc.goldern.members.model.service;

import org.springframework.stereotype.Service;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CustomerEdit;
import com.jdc.goldern.members.model.dto.input.CustomerSearch;
import com.jdc.goldern.members.model.dto.output.CustomerDetails;
import com.jdc.goldern.members.model.dto.output.CustomerList;

@Service
public class CustomerService {

	public PageResponse<CustomerList> search(CustomerSearch form) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerDetails findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerEdit findForEdit(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerDetails create(CustomerEdit form) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerDetails update(long id, CustomerEdit form) {
		// TODO Auto-generated method stub
		return null;
	}

}
