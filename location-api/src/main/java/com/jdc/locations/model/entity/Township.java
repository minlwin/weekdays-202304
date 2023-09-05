package com.jdc.locations.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_township", allocationSize = 1)
public class Township {

	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String name;
	@ManyToOne(optional = false)
	private Division division;
}
