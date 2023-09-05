package com.jdc.locations.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.locations.exceptions.LocationAppException;
import com.jdc.locations.exceptions.LocationAppException.Type;
import com.jdc.locations.model.DivisionForm;
import com.jdc.locations.model.entity.Division;
import com.jdc.locations.model.repo.DivisionRepo;

@Service
public class DivisionService {
	
	@Autowired
	private DivisionRepo repo;

	public List<Division> search(Optional<String> region, Optional<String> name) {
		return repo.findAll(whichRegion(region).and(whichName(name)));
	}
	
	private Specification<Division> whichRegion(Optional<String> params) {
		return params.isEmpty() ? Specification.where(null) :
			(root, query, cb) -> cb.equal(root.get("region"), params.get());
	}

	private Specification<Division> whichName(Optional<String> params) {
		return params.isEmpty() ? Specification.where(null) :
			(root, query, cb) -> cb.like(cb.lower(root.get("name")), params.get().toLowerCase().concat("%"));
	}

	public Division findById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new LocationAppException(Type.Business, List.of("There is no division with id: %d.".formatted(id))));
	}

	@Transactional
	public Division create(DivisionForm form) {
		return repo.save(form.entity());
	}

	@Transactional
	public Division update(int id, DivisionForm form) {
		return repo.findById(id).map(entity -> {
			entity.setName(form.name());
			entity.setRegion(form.region());
			return entity;
		})
		.orElseThrow(() -> new LocationAppException(Type.Business, List.of("There is no division with id: %d.".formatted(id))));
	}

}
