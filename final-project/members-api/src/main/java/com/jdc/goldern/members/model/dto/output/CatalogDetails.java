package com.jdc.goldern.members.model.dto.output;

import java.util.List;

import lombok.Data;

@Data
public class CatalogDetails {

	private CatalogList info;

	private List<String> images;

	private List<Review> reviews;

}