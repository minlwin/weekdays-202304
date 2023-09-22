package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.goldern.members.model.entity.CatalogReview;

import lombok.Data;

@Data
public class Review {

	private int rating;

	private String comment;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime issueAt;
	
	public static Review from(CatalogReview entity) {
		var dto = new Review();
		dto.setRating(entity.getRating());
		dto.setComment(entity.getComment());
		dto.setIssueAt(entity.getAudit().getCreateAt());
		return dto;
	}

}