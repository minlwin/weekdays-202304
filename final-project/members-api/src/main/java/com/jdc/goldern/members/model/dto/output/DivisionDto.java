package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Division;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DivisionDto {

	private int id;
	private String name;
	private long townships;
	
	public static void select(CriteriaQuery<DivisionDto> query, Root<Division> root, CriteriaBuilder cb) {
		query.multiselect(
				root.get("id"),
				root.get("name"),
				cb.count(root.join("townships"))
		);
	}
}
