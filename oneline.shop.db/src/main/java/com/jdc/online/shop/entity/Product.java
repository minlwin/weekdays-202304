package com.jdc.online.shop.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name = "PRODUCT_SEQ")
public class Product {

	@Id
	@GeneratedValue(generator = "PRODUCT_SEQ")
	private int id;

	@ManyToOne(optional = false)
	private Category category;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String brand;

	private int price;

	@ElementCollection
	@CollectionTable(name = "PRODUCT_PHOTOS", joinColumns = @JoinColumn(name = "product_id"))
	private List<Photo> photos;

	@ElementCollection
	@MapKeyColumn(name = "feature")
	@CollectionTable(name = "PRODUCT_FEATURES", joinColumns = @JoinColumn(name = "product_id"))
	private Map<String, String> features;

}