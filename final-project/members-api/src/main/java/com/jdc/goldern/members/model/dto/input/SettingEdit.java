package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SettingEdit {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate refDate;
	private int months;
}
