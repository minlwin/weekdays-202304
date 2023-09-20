package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Division;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DivisionDto {

	private int id;
	private String name;
	
	public static DivisionDto from(Division entity) {
		return new DivisionDto(entity.getId(), entity.getName());
	}
}
