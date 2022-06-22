package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Product {
	/*
	 * private String name; 
	 * private int price;
	 */
	private Integer productNumber;
	private String productName;
	private Integer productPrice;
	private Integer discountRate;

}
