package com.jdc.goldern.members.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.goldern.members.model.dto.output.DivisionDto;
import com.jdc.goldern.members.model.dto.output.TownshipDto;
import com.jdc.goldern.members.model.entity.Township;
import com.jdc.goldern.members.model.repo.DivisionRepo;
import com.jdc.goldern.members.model.repo.TownshipRepo;

@Service
@Transactional(readOnly = true)
public class LocationService {
	
	@Autowired
	private DivisionRepo divisionRepo;
	@Autowired
	private TownshipRepo townshipRepo;

	public List<DivisionDto> getAllDivisions() {
		return divisionRepo.findAll().stream().map(DivisionDto::from).toList();
	}

	public List<TownshipDto> searchTownship(Optional<Integer> division) {
		
		Specification<Township> where = null == division || division.filter(a -> a > 0).isEmpty() ? 
				Specification.where(null) : (root, query, cb) -> 
					cb.equal(root.get("division").get("id"), division.get());
		
		return townshipRepo.findAll(where).stream().map(TownshipDto::from).toList();
	}

}
