package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.jdc.goldern.members.model.entity.consts.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerEdit {

	@NotBlank(message = "Please enter customer name.")
	private String name;

	@NotBlank(message = "Please enter phone number.")
	private String phone;

	@NotBlank(message = "Please enter email for login.")
	private String email;

	@NotBlank(message = "Please enter NRC number.")
	private String nrcNumber;

	private Gender gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	@NotBlank(message = "Please enter customer address.")
	private String address;

	@NotNull(message = "Please enter township.")
	private Integer township;

	private String remark;

	private Long refererId;

	private boolean deleted;

}