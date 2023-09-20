package com.jdc.goldern.members.api;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.input.SettingEdit;
import com.jdc.goldern.members.model.dto.output.SettingDto;

@RestController
@RequestMapping("manager/settings")
public class ManagerSettingApi {

	@GetMapping
	public List<SettingDto> find() {
		// TODO implement here
		return null;
	}

	@PostMapping
	public SettingDto save(@Validated @RequestBody SettingEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

}