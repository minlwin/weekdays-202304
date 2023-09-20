package com.jdc.goldern.members.model.entity.embedded;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AuditInfo {

	private boolean deleted;

	private LocalDateTime createAt;

	private String createBy;

	private LocalDateTime updateAt;

	private String updateBy;

}