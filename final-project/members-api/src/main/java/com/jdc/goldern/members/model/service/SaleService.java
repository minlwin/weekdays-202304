package com.jdc.goldern.members.model.service;

import org.springframework.stereotype.Service;

import com.jdc.goldern.members.model.dto.PageResponse;
import com.jdc.goldern.members.model.dto.input.SaleEdit;
import com.jdc.goldern.members.model.dto.input.SaleSearch;
import com.jdc.goldern.members.model.dto.output.SaleDetails;
import com.jdc.goldern.members.model.dto.output.SaleList;

@Service
public class SaleService {

	public PageResponse<SaleList> searchForCustomer(long customerId, int page, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	public SaleDetails findDetails(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public SaleDetails create(SaleEdit form) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageResponse<SaleList> searchForEmployee(SaleSearch form, int page, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	public SaleDetails update(long id, SaleEdit form) {
		// TODO Auto-generated method stub
		return null;
	}

	public SaleEdit findForEdit(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
