package com.jdc.online.shop.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ORDERS_PRODUCT")
public class OrderProduct {

	@EmbeddedId
	private OrderProductPK id;
	
	@ManyToOne(optional = false)
	@JoinColumn(updatable = false, insertable = false)
	private Order order;

	@ManyToOne(optional = false)
	@JoinColumn(updatable = false, insertable = false)
	private Product product;
	
	private int quantity;
	private int unitPrice;
	
	public OrderProduct() {
		id = new OrderProductPK();
	}
	
	public void setProduct(Product product) {
		id.setProductId(product.getId());
	}
	
	public void setOrder(Order order) {
		id.setOrderId(order.getId());
	}

}