package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Review {

	private int rating;

	private String comment;

	private LocalDateTime issueAt;

}