package com.farmatodo.purchase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseResponseDto {

	private String message;
	private Long invoiceNumber;
	private double price;
}
