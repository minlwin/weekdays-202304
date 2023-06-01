package com.jdc.demo.model.dto;

public record MemberListDto(
		MemberDto member, long posts, long comments) {

}
