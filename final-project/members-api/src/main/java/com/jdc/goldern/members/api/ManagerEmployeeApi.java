package com.jdc.goldern.members.api;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.EmployeeEdit;
import com.jdc.goldern.members.model.dto.input.EmployeeSearch;
import com.jdc.goldern.members.model.dto.output.EmployeeDetails;
import com.jdc.goldern.members.model.dto.output.EmployeeList;

public class ManagerEmployeeApi {

	public PageResponse<EmployeeList> search(EmployeeSearch form) {
		// TODO implement here
		return null;
	}

	public EmployeeDetails findById(int id) {
		// TODO implement here
		return null;
	}

	public EmployeeEdit findByIdForEdit(int id) {
		// TODO implement here
		return null;
	}

	public EmployeeDetails create(EmployeeEdit form) {
		// TODO implement here
		return null;
	}

	public EmployeeDetails update(int id, EmployeeEdit form) {
		// TODO implement here
		return null;
	}

}