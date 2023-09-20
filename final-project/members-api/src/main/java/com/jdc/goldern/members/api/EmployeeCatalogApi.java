package com.jdc.goldern.members.api;

import java.util.List;

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
import com.jdc.goldern.members.model.dto.output.CatalogList;

@RestController
@RequestMapping("employee/catalogs")
public class EmployeeCatalogApi {

	@GetMapping
	public PageResponse<CatalogList> search(CatalogSearch form) {
		// TODO implement here
		return null;
	}

	@GetMapping("{id}")
	public CatalogDetails findById(@PathVariable int id) {
		// TODO implement here
		return null;
	}

	@PostMapping
	public CatalogDetails create(@Validated @RequestBody CatalogEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

	@PutMapping("{id}")
	public CatalogDetails update(@PathVariable int id, @Validated @RequestBody CatalogEdit form, BindingResult result) {
		// TODO implement here
		return null;
	}

	@GetMapping("{id}/uploads")
	public CatalogDetails uploadPhotots(@PathVariable int id, @RequestParam List<MultipartFile> files) {
		// TODO implement here
		return null;
	}

}