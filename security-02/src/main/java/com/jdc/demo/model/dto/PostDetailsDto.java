package com.jdc.demo.model.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;

public record PostDetailsDto(
		PostDto post, 
		List<PostPhotoDto> photos, 
		List<PostCommentDto> comments
		) {
	
	public int getId() {
		return post.id();
	}

	public String getTitle() {
		return post.title();
	}
	
	public String getPostAt() {
		return post.postAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
