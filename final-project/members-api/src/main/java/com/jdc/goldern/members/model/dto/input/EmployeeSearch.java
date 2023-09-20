package com.jdc.goldern.members.model.dto.input;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.jdc.goldern.members.model.entity.Employee;

import lombok.Data;

@Data
public class EmployeeSearch {

	private Optional<Long> id;

	private Optional<String> name;

	private Optional<String> phone;
	
	public Specification<Employee> where() {
		Specification<Employee> spec = Specification.where(null);
		
		spec = null == id || id.filter(a -> a > 0).isEmpty() ? spec :
			(root, query, cb) -> cb.equal(root.get("id"), id.get());
		
		spec = null == name || name.filter(a -> !StringUtils.hasLength(a)).isEmpty() ? spec :
			(root, query, cb) -> cb.like(cb.lower(root.get("name")), name.get().toLowerCase().concat("%"));

		spec = null == phone || phone.filter(a -> !StringUtils.hasLength(a)).isEmpty() ? spec :
			(root, query, cb) -> cb.like(cb.lower(root.get("phone")), phone.get().toLowerCase().concat("%"));

		return spec;
	}

}