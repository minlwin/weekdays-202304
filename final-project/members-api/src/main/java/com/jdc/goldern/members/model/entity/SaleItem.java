package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "sale_item_seq", allocationSize = 1)
public class SaleItem {

	@Id
	@GeneratedValue(generator = "sale_item_seq")
	private long id;

	@ManyToOne(optional = false)
	private Sale sale;

	@ManyToOne(optional = false)
	private Catalog catalog;

	@Column(nullable = false)
	private BigDecimal salePrice;

}