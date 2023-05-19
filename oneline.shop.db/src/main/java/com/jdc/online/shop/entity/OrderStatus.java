package com.jdc.online.shop.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.online.shop.entity.Order.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "ORDERS_STATUS")
public class OrderStatus {

	@EmbeddedId
	private OrderStatusPK id;

	@ManyToOne(optional = false)
	@JoinColumn(updatable = false, insertable = false)
	private Order order;

	@Column(nullable = false)
	private Status status;
	
	public OrderStatus() {
		id = new OrderStatusPK();
	}
	
	public void setOrder(Order order) {
		id.setOrderId(order.getId());
	}

}