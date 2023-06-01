package com.jdc.demo.model.dto;

public record PostListDto(
		PostDto post, PostPhotoDto photo, long comments, long photos
		) {

}
