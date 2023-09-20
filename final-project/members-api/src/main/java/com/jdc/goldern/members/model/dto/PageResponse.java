package com.jdc.goldern.members.model.dto;

import java.util.List;

import org.springframework.data.domain.Page;

public record PageResponse<T>(List<T> content, PageInfo page) {

	public static<T> PageResponse<T> from(Page<T> result) {
		return new PageResponse<T>(result.getContent(), new PageInfo(result.getNumber(), result.getSize(), result.getTotalElements()));
	}
}