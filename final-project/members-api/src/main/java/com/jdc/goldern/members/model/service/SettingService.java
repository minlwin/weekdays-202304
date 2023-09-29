package com.jdc.goldern.members.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.goldern.members.model.dto.input.SettingEdit;
import com.jdc.goldern.members.model.dto.output.SettingDto;
import com.jdc.goldern.members.model.repo.ReferPeriodSettingRepo;

@Service
@Transactional(readOnly = false)
public class SettingService {
	
	@Autowired
	private ReferPeriodSettingRepo repo;

	public List<SettingDto> findAll() {
		return null;
//		return repo.findAllOederByCreateAtDesc().stream()
//				.map(SettingDto::from).toList();
	}

	@Transactional
	public SettingDto save(SettingEdit form) {
		var entity = repo.save(form.entity());
		return SettingDto.from(entity);
	}

}
