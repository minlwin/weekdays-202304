package com.jdc.locations.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_division", allocationSize = 1)
public class Division {

	@Id
	@GeneratedValue(generator = "seq_division")
	private int id;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(nullable = false)
	private String region;
}
