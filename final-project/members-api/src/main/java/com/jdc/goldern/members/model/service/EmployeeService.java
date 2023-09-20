package com.jdc.goldern.members.model.service;

import org.springframework.stereotype.Service;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.EmployeeEdit;
import com.jdc.goldern.members.model.dto.input.EmployeeSearch;
import com.jdc.goldern.members.model.dto.output.EmployeeDetails;
import com.jdc.goldern.members.model.dto.output.EmployeeList;

@Service
public class EmployeeService {

	public PageResponse<EmployeeList> search(EmployeeSearch form) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDetails findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeEdit findForEdit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDetails create(EmployeeEdit form) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDetails update(int id, EmployeeEdit form) {
		// TODO Auto-generated method stub
		return null;
	}

}
