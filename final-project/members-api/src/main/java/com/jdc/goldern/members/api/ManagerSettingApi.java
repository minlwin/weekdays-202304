package com.jdc.goldern.members.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.input.SettingEdit;
import com.jdc.goldern.members.model.dto.output.SettingDto;
import com.jdc.goldern.members.model.service.SettingService;

@RestController
@RequestMapping("manager/settings")
public class ManagerSettingApi {
	
	@Autowired
	private SettingService service;

	@GetMapping
	public List<SettingDto> find() {
		return service.findAll();
	}

	@PostMapping
	public SettingDto save(@Validated @RequestBody SettingEdit form, BindingResult result) {
		return service.save(form);
	}

}