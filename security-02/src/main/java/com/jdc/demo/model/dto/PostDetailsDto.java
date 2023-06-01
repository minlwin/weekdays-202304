package com.jdc.demo.model.dto;

import java.util.List;

public record PostDetailsDto(
		PostDto post, 
		List<PostPhotoDto> photos, 
		List<PostCommentDto> comments
		) {

}
