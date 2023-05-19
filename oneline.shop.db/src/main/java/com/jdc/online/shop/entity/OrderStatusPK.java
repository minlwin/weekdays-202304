package com.jdc.online.shop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class OrderStatusPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "update_at")
	private LocalDateTime updateAt;

}