package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SettingEdit {

	@NotNull(message = "Please enter reference date for setting.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate refDate;
	
	@NotNull(message = "Please enter months for setting.")
	private Integer months;
}
