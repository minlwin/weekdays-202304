package com.jdc.demo.model.dto;

import java.time.LocalDateTime;

public record PostCommentDto(
		int id, String details, LocalDateTime commentAt, MemberDto member
		) {

}
