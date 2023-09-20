package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;
import java.util.List;

import com.jdc.goldern.members.model.entity.embedded.AuditInfo;

import lombok.Data;

@Data
public class Catalog {

	private int id;

	private String name;

	private List<Category> categories;

	private String description;

	private BigDecimal weight;

	private BigDecimal purity;

	private BigDecimal goldSmithFees;

	private BigDecimal lostWeight;

	private BigDecimal price;

	private AuditInfo audit;

}