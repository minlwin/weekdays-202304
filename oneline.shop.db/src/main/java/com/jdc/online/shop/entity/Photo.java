package com.jdc.online.shop.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Photo {

	private String url;
	private boolean cover;

}