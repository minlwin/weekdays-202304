package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.goldern.members.model.entity.ReferPeriodSetting;

import lombok.Data;

@Data
public class SettingDto {

	private int id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate refDate;
	private int months;
	private boolean deleted;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateAt;
	private String createBy;
	private String updateBy;
	
	public static SettingDto from(ReferPeriodSetting entity) {
		var dto = new SettingDto();
		dto.setId(entity.getId());
		dto.setRefDate(entity.getRefDate());
		dto.setMonths(entity.getMonths());
		dto.setDeleted(entity.getAudit().isDeleted());
		dto.setCreateAt(entity.getAudit().getCreateAt());
		dto.setCreateBy(entity.getAudit().getCreateBy());
		dto.setUpdateAt(entity.getAudit().getUpdateAt());
		dto.setUpdateBy(entity.getAudit().getUpdateBy());
		return dto;
	}
}
