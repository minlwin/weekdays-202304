package com.jdc.goldern.members.model.dto;

import lombok.Data;

@Data
public class PageInfo {

	private int currentPage;

	private int pageSize;

	private long totalCount;

}