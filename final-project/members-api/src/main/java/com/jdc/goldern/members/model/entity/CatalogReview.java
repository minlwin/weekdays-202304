package com.jdc.goldern.members.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.embedded.AuditingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "catalog_review_seq", allocationSize = 1)
public class CatalogReview extends AuditingEntity{

	@Id
	@GeneratedValue(generator = "catalog_review_seq")
	private long id;
	@Column(nullable = false)
	private String comment;
	private int rating;
	@ManyToOne(optional = false)
	private Customer customer;
	@ManyToOne(optional = false)
	private Catalog catalog;
	
}
