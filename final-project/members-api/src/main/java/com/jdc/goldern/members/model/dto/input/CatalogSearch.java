package com.jdc.goldern.members.model.dto.input;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.jdc.goldern.members.model.entity.Catalog;

import lombok.Data;

@Data
public class CatalogSearch {

	private Optional<String> keyword;

	private Optional<Integer> categoryId;

	public Specification<Catalog> where() {
		Specification<Catalog> spec = Specification.where(null);
		
		spec = null == categoryId || categoryId.filter(id -> id > 0).isEmpty() ? spec :
			spec.and((root, query, cb) -> cb.equal(root.get("category").get("id"), categoryId.get()));

		spec = null == keyword || keyword.filter(StringUtils::hasLength).isEmpty() ? spec :
			spec.and((root, query, cb) -> cb.or(
				cb.like(cb.lower(root.get("name")), keyword.get().toLowerCase().concat("%")),
				cb.like(cb.lower(root.get("catagory").get("name")), keyword.get().toLowerCase().concat("%"))
			));
		
		return spec;
	}
}