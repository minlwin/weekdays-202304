package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.embedded.AuditingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@SequenceGenerator(name = "sale_seq", allocationSize = 1)
@EntityListeners(value = AuditingEntityListener.class)
public class Sale extends AuditingEntity{

	@Id
	@GeneratedValue(generator = "sale_seq")
	private long id;

	@Column(nullable = false)
	private LocalDateTime issueAt;

	@ManyToOne(optional = false)
	private Customer customer;
	
	@ManyToOne(optional = false)
	private Employee employee;

	@OneToOne(mappedBy = "sale")
	private Reward reward;

	@OneToMany(mappedBy = "sale", orphanRemoval = true)
	private List<SaleItem> items;

	@Column(nullable = false)
	private BigDecimal totalPrice;

	@Column(nullable = false)
	private BigDecimal totalLostWeight;

	@Column(nullable = false)
	private BigDecimal totalGoldSmithFees;


}