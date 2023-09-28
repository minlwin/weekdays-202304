package com.jdc.goldern.members.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.consts.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = AuditingEntityListener.class)
public class Customer extends Account {

	private Gender gender;

	private LocalDate dateOfBirth;
	
	@Column(nullable = false)
	private LocalDateTime registerAt;

	@OneToOne(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Address address;

	@ManyToOne
	private Account referer;
	
	@OneToMany(mappedBy = "customer")
	private List<Sale> purchases;
	
	public void setAddress(Address address) {
		this.address = address;
		address.setCustomer(this);
	}

}