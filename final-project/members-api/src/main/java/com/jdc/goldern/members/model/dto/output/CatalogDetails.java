package com.jdc.goldern.members.model.dto.output;

import java.util.ArrayList;
import java.util.List;

import com.jdc.goldern.members.model.entity.Catalog;

import lombok.Data;

@Data
public class CatalogDetails {

	private CatalogDto info;
	
	private List<String> images;

	private List<Review> reviews;
	
	public static CatalogDetails from(Catalog entity) {
		var dto = new CatalogDetails();
		dto.setInfo(CatalogDto.from(entity));
		dto.setImages(new ArrayList<>(entity.getImages()));
		dto.setReviews(entity.getReviews().stream().map(Review::from).toList());
		return dto;
	}

}