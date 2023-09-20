package com.jdc.goldern.members.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class PageResponse<T> {

	private List<T> content;

	private PageInfo page;

}