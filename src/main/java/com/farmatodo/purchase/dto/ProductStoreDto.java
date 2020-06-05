package com.farmatodo.purchase.dto;

import lombok.Data;

@Data
public class ProductStoreDto {

	private Long productId;
	private String productName;
	private int quantity;
	private double productPrice;
}
