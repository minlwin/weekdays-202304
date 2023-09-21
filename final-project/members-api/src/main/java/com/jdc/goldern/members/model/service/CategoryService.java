package com.jdc.goldern.members.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.goldern.members.model.dto.input.CategoryEdit;
import com.jdc.goldern.members.model.dto.output.CategoryDto;
import com.jdc.goldern.members.model.dto.output.CategoryList;
import com.jdc.goldern.members.model.entity.Catalog;
import com.jdc.goldern.members.model.entity.Category;
import com.jdc.goldern.members.model.repo.CategoryRepo;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

@Service
@Transactional(readOnly = true)
public class CategoryService {

	@Autowired
	private CategoryRepo repo;
	
	public List<CategoryDto> findAll() {
		return repo.findAll().stream().map(CategoryDto::from).toList();
	}

	public List<CategoryList> getAllForCompany() {
		return repo.findAll(cb -> {
			var query = cb.createQuery(CategoryList.class);
			var root = query.from(Category.class);
			
			Join<Category, Catalog> catalog = root.join("catalogs", JoinType.LEFT);
			query.multiselect(root.get("id"), root.get("name"), cb.count(catalog));
			query.groupBy(root.get("id"), root.get("name"));
			
			return query;
		});
	}

	@Transactional
	public List<CategoryList> create(CategoryEdit form) {
		repo.save(form.entity());
		return getAllForCompany();
	}

	@Transactional
	public List<CategoryList> update(int id, CategoryEdit form) {
		repo.findById(id).ifPresent(entity -> {
			entity.setName(form.getName());
			entity.getAudit().setDeleted(form.isDeleted());
		});
		return getAllForCompany();
	}
	
}
