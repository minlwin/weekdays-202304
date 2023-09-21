package com.jdc.goldern.members.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CatalogSearch;
import com.jdc.goldern.members.model.dto.output.CatalogDetails;
import com.jdc.goldern.members.model.dto.output.CatalogList;
import com.jdc.goldern.members.model.service.CatalogService;

@RestController
@RequestMapping("public/catalogs")
public class PublicCatalogApi {
	
	@Autowired
	private CatalogService service;

	@GetMapping
	public PageResponse<CatalogList> search(CatalogSearch form, 
			@RequestParam(defaultValue = "0") int page,  
			@RequestParam(defaultValue = "10") int max) {
		return service.search(form, page, max);
	}

	@GetMapping("{id}")
	public CatalogDetails findById(@PathVariable int id) {
		return service.findDetails(id);
	}

}