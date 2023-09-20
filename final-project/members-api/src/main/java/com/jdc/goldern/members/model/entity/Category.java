package com.jdc.goldern.members.model.entity;

import java.util.List;

import com.jdc.goldern.members.model.entity.embedded.AuditInfo;

import lombok.Data;

@Data
public class Category {

	private int id;

	private String name;

	private List<Catalog> catalogs;

	private AuditInfo audit;

}