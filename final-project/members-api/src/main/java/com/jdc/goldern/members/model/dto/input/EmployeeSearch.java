package com.jdc.goldern.members.model.dto.input;

import java.util.Optional;

import lombok.Data;

@Data
public class EmployeeSearch {

	private Optional<Long> id;

	private Optional<String> name;

	private Optional<String> phone;

}