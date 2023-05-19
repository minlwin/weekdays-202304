package com.jdc.online.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class OrderProductPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "order_id")
	private long orderId;
	@Column(name = "product_id")
	private int productId;

}