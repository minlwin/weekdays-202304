package com.jdc.goldern.members.model.dto.input;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.jdc.goldern.members.model.entity.Catalog;

import jakarta.persistence.criteria.JoinType;
import lombok.Data;

@Data
public class CatalogSearch {

	private Optional<String> keyword;

	private Optional<List<Integer>> categoryIds;

	public Specification<Catalog> where() {
		Specification<Catalog> spec = Specification.where(null);
		
		spec = null == categoryIds || categoryIds.filter(ids -> !ids.isEmpty()).isEmpty() ? spec :
			spec.and((root, query, cb) -> {
				var inClause = cb.in(root.join("categories", JoinType.LEFT).get("id"));
				categoryIds.get().forEach(inClause::value);
				return inClause;
			});

		spec = null == keyword || keyword.filter(StringUtils::hasLength).isEmpty() ? spec :
			spec.and((root, query, cb) -> cb.or(
				cb.like(cb.lower(root.get("name")), keyword.get().toLowerCase().concat("%")),
				cb.like(cb.lower(root.join("categories", JoinType.LEFT).get("name")), keyword.get().toLowerCase().concat("%"))
			));
		
		return spec;
	}
	
}