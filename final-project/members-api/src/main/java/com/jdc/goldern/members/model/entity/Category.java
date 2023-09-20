package com.jdc.goldern.members.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.embedded.AuditingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "category_seq", allocationSize = 1)
public class Category extends AuditingEntity{

	@Id
	@GeneratedValue(generator = "category_seq")
	private int id;

	@Column(nullable = false, unique = true)
	private String name;

	@ManyToMany
	private List<Catalog> catalogs = new ArrayList<>();
}