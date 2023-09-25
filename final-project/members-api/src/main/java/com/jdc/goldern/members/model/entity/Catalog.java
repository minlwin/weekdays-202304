package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.embedded.AuditingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "catalog_seq", allocationSize = 1)
public class Catalog extends AuditingEntity{

	@Id
	@GeneratedValue(generator = "catalog_seq")
	private int id;

	@Column(nullable = false)
	private String name;

	@ManyToMany
	private List<Category> categories = new ArrayList<>();
	
	@ElementCollection
	private List<String> images = new ArrayList<>();
	
	private String coverImage;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private BigDecimal weight;

	@Column(nullable = false)
	private BigDecimal purity;

	@Column(nullable = false)
	private BigDecimal goldSmithFees;

	@Column(nullable = false)
	private BigDecimal lostWeight;

	@Column(nullable = false)
	private BigDecimal price;
	
	@OneToMany(mappedBy = "catalog")
	private List<SaleItem> saleItems = new ArrayList<>();
	
	@OneToMany(mappedBy = "catalog")
	private List<CatalogReview> reviews = new ArrayList<>();
	
	

}