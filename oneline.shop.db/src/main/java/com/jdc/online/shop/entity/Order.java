package com.jdc.online.shop.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "ORDERS")
@SequenceGenerator(name = "ORDERS_SEQ")
public class Order {

	@Id
	@GeneratedValue(generator = "ORDERS_SEQ")
	private long id;
	
	@ManyToOne(optional = false)
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	private List<OrderProduct> products;
	
	@Column(name = "issue_at")
	private LocalDateTime issueAt;
	
	private Status status;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "address_id")
	private Address deliveryAddress;
	
	@Column(name = "delivery_fees")
	private int deliveryFees;

	public enum Status {
		Ordered,
		Delivered,
		Finished,
		Cancel
	}

}