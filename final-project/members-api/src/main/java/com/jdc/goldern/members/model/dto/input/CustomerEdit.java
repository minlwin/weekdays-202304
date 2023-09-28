package com.jdc.goldern.members.model.dto.input;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.goldern.members.model.entity.Address;
import com.jdc.goldern.members.model.entity.Customer;
import com.jdc.goldern.members.model.entity.consts.Gender;
import com.jdc.goldern.members.model.entity.consts.Role;
import com.jdc.goldern.members.model.repo.AccountRepo;
import com.jdc.goldern.members.model.repo.TownshipRepo;

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
	
	public static CustomerEdit from(Customer entity) {
		var dto = new CustomerEdit();
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		dto.setEmail(entity.getEmail());
		dto.setNrcNumber(entity.getNrcNumber());
		dto.setRemark(entity.getRemark());
		dto.setGender(entity.getGender());
		dto.setDateOfBirth(entity.getDateOfBirth());
		
		var referer = entity.getReferer();
		if(null != referer) {
			dto.setRefererId(referer.getId());
		}
		
		var address = entity.getAddress();
		if(null != address) {
			dto.setAddress(address.getAddress());
			dto.setTownship(address.getTownship().getId());
		}
		
		dto.setDeleted(entity.getAudit().isDeleted());
		return dto;
	}
	
	public Customer entity(PasswordEncoder encoder, AccountRepo accountRepo, TownshipRepo townshipRepo) {
		
		var dto = new Customer();
		dto.setName(name);
		dto.setPhone(phone);
		dto.setPassword(encoder.encode(phone));
		dto.setEmail(email);
		dto.setNrcNumber(nrcNumber);
		dto.setRegisterAt(LocalDateTime.now());
		dto.setRole(Role.Customer);
		dto.setRemark(remark);
		dto.getAudit().setDeleted(deleted);
		dto.setGender(gender);
		dto.setDateOfBirth(dateOfBirth);
		dto.setReferer(accountRepo.getReferenceById(refererId));
		
		var addressEntity = new Address();
		addressEntity.setAddress(address);
		addressEntity.setCustomer(dto);
		addressEntity.setTownship(townshipRepo.getReferenceById(township));
		
		return dto;
	}

}