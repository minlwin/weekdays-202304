package com.jdc.goldern.members.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CatalogSearch;
import com.jdc.goldern.members.model.dto.input.ReviewForm;
import com.jdc.goldern.members.model.dto.output.CatalogDetails;
import com.jdc.goldern.members.model.dto.output.CatalogDto;
import com.jdc.goldern.members.model.service.CatalogService;

@RestController
@RequestMapping("public/catalogs")
public class PublicCatalogApi {
	
	@Autowired
	private CatalogService service;

	@GetMapping
	public PageResponse<CatalogDto> search(CatalogSearch form, 
			@RequestParam(defaultValue = "0") int page,  
			@RequestParam(defaultValue = "10") int max) {
		return PageResponse.from(service.search(form, page, max));
	}

	@GetMapping("{id}")
	public CatalogDetails findById(@PathVariable int id) {
		return service.findDetails(id);
	}

	@PreAuthorize("hasRole('EMPLOYEE') and authentication.name eq username")
	@PostMapping("review/{id}/{username}")
	public CatalogDetails review(
			@PathVariable("id") long catalogId,
			@PathVariable String username,
			@RequestBody ReviewForm form, BindingResult result
			) {
		return service.makeReview(catalogId, username, form);
	}

}