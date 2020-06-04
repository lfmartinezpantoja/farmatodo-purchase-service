package com.farmatodo.purchase.dto;

import lombok.Data;

@Data
public class ProductPurchaseDto {

	private String productName;
	private int quantity;
	private int currentQuantity;
	private Long productId;
}
