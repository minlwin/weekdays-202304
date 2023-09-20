package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
}
