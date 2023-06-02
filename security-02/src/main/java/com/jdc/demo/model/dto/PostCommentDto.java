package com.jdc.demo.model.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record PostCommentDto(
		int id, String details, LocalDateTime commentAt, MemberDto member
		) {
	
	public String getOwner() {
		return member.name();
	}
	
	public String getCommentAt() {
		return commentAt.format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss"));
	}
}	
