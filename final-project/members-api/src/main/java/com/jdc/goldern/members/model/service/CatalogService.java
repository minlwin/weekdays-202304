package com.jdc.goldern.members.model.service;

import org.springframework.stereotype.Service;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.CatalogSearch;
import com.jdc.goldern.members.model.dto.output.CatalogDetails;
import com.jdc.goldern.members.model.dto.output.CatalogList;

@Service
public class CatalogService {

	public PageResponse<CatalogList> search(CatalogSearch form, int page, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	public CatalogDetails findDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
