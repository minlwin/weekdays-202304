package com.jdc.goldern.members.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CatalogSearch;
import com.jdc.goldern.members.model.dto.output.CatalogDetails;
import com.jdc.goldern.members.model.dto.output.CatalogList;

@RestController
@RequestMapping("public/catalogs")
public class PublicCatalogApi {

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

}