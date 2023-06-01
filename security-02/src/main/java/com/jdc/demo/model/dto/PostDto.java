package com.jdc.demo.model.dto;

import java.time.LocalDateTime;

public record PostDto(
		int id, String title, LocalDateTime postAt, MemberDto owner
		) {

}
