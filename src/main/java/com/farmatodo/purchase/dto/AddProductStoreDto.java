package com.farmatodo.purchase.dto;

import lombok.Data;

@Data
public class AddProductStoreDto {

	private String productName;
	private String storeName;
	private int quantity;
	
}
