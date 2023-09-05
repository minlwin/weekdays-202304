package com.jdc.locations.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.locations.exceptions.LocationAppException;
import com.jdc.locations.exceptions.LocationAppException.Type;
import com.jdc.locations.model.TownshipForm;
import com.jdc.locations.model.entity.Township;
import com.jdc.locations.model.repo.TownshipRepo;

@Service
@Transactional(readOnly = true)
public class TownshipService {
	
	@Autowired
	private TownshipRepo repo;
	
	@Autowired
	private DivisionService divisionService;

	public List<Township> search(Optional<Integer> division, Optional<String> name) {
		return repo.findAll(whichDivision(division).and(whichName(name)));
	}
	
	private Specification<Township> whichDivision(Optional<Integer> params) {
		return params.isEmpty() ? Specification.where(null) :
			(root, query, cb) -> cb.equal(root.get("division").get("id"), params.get());
	}
	
	private Specification<Township> whichName(Optional<String> params) {
		return params.isEmpty() ? Specification.where(null) :
			(root, query, cb) -> cb.like(cb.lower(root.get("name")), params.get().toLowerCase().concat("%"));
	}
	

	public Township findById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new LocationAppException(Type.Business, List.of("There is no township with id: %d.".formatted(id))));
	}
	
	@Transactional
	public Township create(TownshipForm form) {
		return repo.save(form.entity(divisionService::findById));
	}

	@Transactional
	public Township update(int id, TownshipForm form) {
		return repo.findById(id).map(entity -> {
			entity.setDivision(divisionService.findById(form.divisionId()));
			entity.setName(form.name());
			return entity;
		})
		.orElseThrow(() -> new LocationAppException(Type.Business, List.of("There is no township with id: %d.".formatted(id))));
	}

}
