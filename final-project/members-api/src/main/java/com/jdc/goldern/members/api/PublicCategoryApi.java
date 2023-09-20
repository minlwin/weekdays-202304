package com.jdc.goldern.members.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.output.CategoryDto;
import com.jdc.goldern.members.model.service.CategoryService;


@RestController
@RequestMapping("public/categories")
public class PublicCategoryApi {
	
	@Autowired
	private CategoryService service;

	@GetMapping
	public List<CategoryDto> findAll() {
		return service.findAll();
	}
}
