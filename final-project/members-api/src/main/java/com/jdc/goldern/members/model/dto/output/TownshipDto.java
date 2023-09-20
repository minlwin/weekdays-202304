package com.jdc.goldern.members.model.dto.output;

import com.jdc.goldern.members.model.entity.Township;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TownshipDto {

	private int id;
	private String name;
	private String division;
	
	public static TownshipDto from(Township entity) {
		return new TownshipDto(entity.getId(), entity.getName(), entity.getDivision().getName());
	}
}
