package com.jdc.goldern.members.model.entity.embedded;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AuditInfo {

	private boolean deleted;

	@CreatedDate
	private LocalDateTime createAt;

	@CreatedBy
	private String createBy;

	@LastModifiedDate
	private LocalDateTime updateAt;

	@LastModifiedBy
	private String updateBy;

}