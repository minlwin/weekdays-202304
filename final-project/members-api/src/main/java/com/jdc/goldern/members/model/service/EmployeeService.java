package com.jdc.goldern.members.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.EmployeeEdit;
import com.jdc.goldern.members.model.dto.input.EmployeeSearch;
import com.jdc.goldern.members.model.dto.output.EmployeeDetails;
import com.jdc.goldern.members.model.dto.output.EmployeeDto;
import com.jdc.goldern.members.model.repo.EmployeeRepo;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public PageResponse<EmployeeDto> search(EmployeeSearch form, int page, int max) {
		var result = repo.findAll(form.where(), PageRequest.of(page, max));
		return PageResponse.from(result.map(EmployeeDto::from));
	}

	public EmployeeDetails findById(long id) {
		return repo.findById(id).map(EmployeeDetails::new).orElseThrow();
	}

	public EmployeeEdit findForEdit(long id) {
		return repo.findById(id).map(EmployeeEdit::from).orElseThrow();
	}

	@Transactional
	public EmployeeDetails create(EmployeeEdit form) {
		var entity = repo.save(form.entity(passwordEncoder));
		return new EmployeeDetails(entity);
	}

	@Transactional
	public EmployeeDetails update(long id, EmployeeEdit form) {
		return repo.findById(id).map(dto -> {
			dto.setName(form.getName());
			dto.setPhone(form.getPhone());
			dto.setEmail(form.getEmail());
			dto.setNrcNumber(form.getNrcNumber());
			dto.setRole(form.getRole());
			dto.setRemark(form.getRemark());
			dto.setAssignAt(form.getAssignAt());
			dto.setRetireAt(form.getRetireAt());
			return new EmployeeDetails(dto);
		}).orElseThrow();
	}

}
