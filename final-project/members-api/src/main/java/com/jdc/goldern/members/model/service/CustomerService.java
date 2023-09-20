package com.jdc.goldern.members.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CustomerEdit;
import com.jdc.goldern.members.model.dto.input.CustomerSearch;
import com.jdc.goldern.members.model.dto.output.CustomerDetails;
import com.jdc.goldern.members.model.dto.output.CustomerList;
import com.jdc.goldern.members.model.repo.CustomerRepo;

@Service
@Transactional(readOnly = true)
public class CustomerService {
	
	@Autowired
	public CustomerRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public PageResponse<CustomerList> search(CustomerSearch form, int page, int max) {
		var result = repo.findAll(form.where(), PageRequest.of(page, max));
		return PageResponse.from(result.map(CustomerList::from));
	}

	public CustomerDetails findById(long id) {
		return repo.findById(id).map(CustomerDetails::new).orElseThrow();
	}

	public CustomerEdit findForEdit(long id) {
		return repo.findById(id).map(CustomerEdit::from).orElseThrow();
	}

	@Transactional
	public CustomerDetails create(CustomerEdit form) {
		var entity = repo.save(form.entity(passwordEncoder));
		return new CustomerDetails(entity);
	}

	@Transactional
	public CustomerDetails update(long id, CustomerEdit form) {
		return repo.findById(id).map(dto -> {
			dto.setName(form.getName());
			dto.setPhone(form.getPhone());
			dto.setEmail(form.getEmail());
			dto.setNrcNumber(form.getNrcNumber());
			dto.setRemark(form.getRemark());
			return new CustomerDetails(dto);
		}).orElseThrow();
	}

}
