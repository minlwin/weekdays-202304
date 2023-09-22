package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.goldern.members.model.entity.Employee;
import com.jdc.goldern.members.model.entity.consts.Role;

import lombok.Data;

@Data
public class EmployeeDto {

	private long id;

	private String name;

	private String phone;

	private String email;

	private String nrcNumber;
	
	private Role role;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate assignAt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate retireAt;

	private String remark;

	private boolean deleted;
	
	public static EmployeeDto from(Employee entity) {
		var dto = new EmployeeDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setNrcNumber(entity.getNrcNumber());
		dto.setRole(entity.getRole());
		dto.setAssignAt(entity.getAssignAt());
		dto.setRetireAt(entity.getRetireAt());
		dto.setRemark(entity.getRemark());
		dto.setDeleted(entity.getAudit().isDeleted());
		return dto;
	}
}