package com.jdc.goldern.members.model.dto.input;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.jdc.goldern.members.model.entity.Customer;

import lombok.Data;

@Data
public class CustomerSearch {

	private Optional<Long> id;
	private Optional<String> name;
	private Optional<String> phone;
	private Optional<String> address;
	
	public Specification<Customer> where() {
		Specification<Customer> spec = Specification.where(null);
		
		spec = null == id || id.filter(a -> a > 0).isEmpty() ? spec :
			(root, query, cb) -> cb.equal(root.get("id"), id.get());
		
		spec = null == name || name.filter(a -> !StringUtils.hasLength(a)).isEmpty() ? spec :
			(root, query, cb) -> cb.like(cb.lower(root.get("name")), name.get().toLowerCase().concat("%"));

		spec = null == phone || phone.filter(a -> !StringUtils.hasLength(a)).isEmpty() ? spec :
			(root, query, cb) -> cb.like(cb.lower(root.get("phone")), phone.get().toLowerCase().concat("%"));

		spec = null == address || address.filter(a -> !StringUtils.hasLength(a)).isEmpty() ? spec :
			(root, query, cb) -> cb.or(
				cb.like(cb.lower(root.get("address").get("address")), address.get().toLowerCase().concat("%")),
				cb.like(cb.lower(root.get("address").get("township").get("name")), address.get().toLowerCase().concat("%")),
				cb.like(cb.lower(root.get("address").get("township").get("division").get("name")), address.get().toLowerCase().concat("%"))
			);

		return spec;
	}

}