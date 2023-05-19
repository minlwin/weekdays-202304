package com.jdc.online.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORY")
@SequenceGenerator(name = "CATEGORY_SEQ")
public class Category {

	@Id
	@GeneratedValue(generator = "CATEGORY_SEQ")
	private int id;
	
	@Column(nullable = false)
	private String name;
	private String image;

}