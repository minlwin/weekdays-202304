package com.jdc.goldern.members.model.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.jdc.goldern.members.model.entity.Catalog;

import lombok.Data;

@Data
public class CatalogDto {

	private int id;
	private String name;
	private BigDecimal price;
	private BigDecimal weight;
	private int rating;
	private boolean isNew;
	private boolean isPopular;
	private String coverImage;
	private String description;
	private BigDecimal goldSmithFees;
	private BigDecimal lostWeight;
	private BigDecimal purity;
	private List<String> categories;
	
	public static CatalogDto from(Catalog entity) {
		var dto = new CatalogDto();
		Double rating = entity.getReviews().stream().mapToInt(a -> a.getRating()).average().orElse(0);
		dto.setRating(rating.intValue());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setWeight(entity.getWeight());
		dto.setDescription(entity.getDescription());
		dto.setGoldSmithFees(entity.getGoldSmithFees());
		dto.setLostWeight(entity.getLostWeight());
		dto.setPurity(entity.getPurity());
		dto.setCoverImage(entity.getCoverImage());
		dto.setNew(LocalDateTime.now().minusMonths(1).isBefore(entity.getAudit().getCreateAt()));
		dto.setPopular(entity.getSaleItems().size() > 10);
		dto.setCategories(entity.getCategories().stream().map(c -> c.getName()).toList());
		return dto;
	}
}