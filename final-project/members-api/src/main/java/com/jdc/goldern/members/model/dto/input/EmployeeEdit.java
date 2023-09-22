package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.goldern.members.model.entity.Employee;
import com.jdc.goldern.members.model.entity.consts.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeEdit {

	@NotBlank(message = "Please enter employee name.")
	private String name;

	@NotBlank(message = "Please enter phone number.")
	private String phone;

	@NotBlank(message = "Please enter email for login.")
	private String email;

	@NotBlank(message = "Please enter NRC number.")
	private String nrcNumber;

	@NotNull(message = "Please enter assign date.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate assignAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate retireAt;

	@NotNull(message = "Please define role for employee.")
	private Role role;

	private String remark;
	
	
	public static EmployeeEdit from(Employee entity) {
		var dto = new EmployeeEdit();
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		dto.setEmail(entity.getEmail());
		dto.setNrcNumber(entity.getNrcNumber());
		dto.setAssignAt(LocalDate.now());
		dto.setRetireAt(entity.getRetireAt());
		dto.setRole(entity.getRole());
		dto.setRemark(entity.getRemark());
		return dto;
	}


	public Employee entity(PasswordEncoder encoder) {
		var dto = new Employee();
		dto.setName(name);
		dto.setPhone(phone);
		dto.setPassword(encoder.encode(phone));
		dto.setEmail(email);
		dto.setNrcNumber(nrcNumber);
		dto.setRole(role);
		dto.setRemark(remark);
		dto.setAssignAt(assignAt);
		dto.setRetireAt(retireAt);
		return dto;
	}
}