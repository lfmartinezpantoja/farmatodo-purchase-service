package com.farmatodo.purchase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreResponseDto {

	private String message;
	private Long storeId;
}
