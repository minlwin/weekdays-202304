package com.jdc.goldern.members.api;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CatalogEdit;
import com.jdc.goldern.members.model.dto.input.CatalogSearch;
import com.jdc.goldern.members.model.dto.output.CatalogDetails;

public class EmployeeCatalogApi {

	public EmployeeCatalogApi() {
	}

	public PageResponse search(CatalogSearch form) {
		// TODO implement here
		return null;
	}

	public CatalogDetails findById(int id) {
		// TODO implement here
		return null;
	}

	public CatalogDetails create(CatalogEdit form) {
		// TODO implement here
		return null;
	}

	public CatalogDetails update(int id, CatalogEdit form) {
		// TODO implement here
		return null;
	}

	public CatalogDetails uploadPhotots(int id, List<MultipartFile> files) {
		// TODO implement here
		return null;
	}

}