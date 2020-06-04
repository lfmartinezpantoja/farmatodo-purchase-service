package com.farmatodo.purchase.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseDto {

	private String username;
	private String password;
	private String storeName;
	private List<ProductPurchaseDto>  products;
	
}
