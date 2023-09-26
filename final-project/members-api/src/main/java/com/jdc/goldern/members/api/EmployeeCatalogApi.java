package com.jdc.goldern.members.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CatalogEdit;
import com.jdc.goldern.members.model.dto.input.CatalogSearch;
import com.jdc.goldern.members.model.dto.output.CatalogDetails;
import com.jdc.goldern.members.model.dto.output.CatalogDto;
import com.jdc.goldern.members.model.service.CatalogService;

@RestController
@RequestMapping("employee/catalogs")
public class EmployeeCatalogApi {
	
	@Autowired
	private CatalogService service;

	@GetMapping
	public PageResponse<CatalogDto> search(
			CatalogSearch form, 
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		return PageResponse.from(service.search(form, page, size));
	}

	@GetMapping("{id}")
	public CatalogDetails findById(@PathVariable long id) {
		return service.findDetails(id);
	}

	@PostMapping
	public CatalogDetails create(@Validated @RequestBody CatalogEdit form, BindingResult result) {
		return service.create(form);
	}

	@PutMapping("{id}")
	public CatalogDetails update(@PathVariable long id, @Validated @RequestBody CatalogEdit form, BindingResult result) {
		return service.update(id, form);
	}

	@PostMapping("{id}/uploads")
	public CatalogDetails uploadPhotots(@PathVariable long id, @RequestParam MultipartFile[] files) {
		return service.photoUpload(id, files);
	}

}