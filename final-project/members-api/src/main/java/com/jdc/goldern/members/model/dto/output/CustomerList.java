package com.jdc.goldern.members.model.dto.output;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.goldern.members.model.entity.Customer;

import lombok.Data;

@Data
public class CustomerList {

	private long id;

	private String name;

	private String phone;

	private String email;

	private String nrcNumber;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime registAt;

	private String remark;
	private boolean deleted;
	
	public static CustomerList from(Customer entity) {
		var list = new CustomerList();
		list.setId(entity.getId());
		list.setName(entity.getName());
		list.setPhone(entity.getPhone());
		list.setEmail(entity.getEmail());
		list.setNrcNumber(entity.getNrcNumber());
		list.setRegistAt(entity.getRegisterAt());
		list.setRemark(entity.getRemark());
		return list;
	}

}