package com.farmatodo.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farmatodo.purchase.dto.PurchaseDto;
import com.farmatodo.purchase.dto.PurchaseResponseDto;
import com.farmatodo.purchase.exception.ServiceException;
import com.farmatodo.purchase.service.PurchaseService;

@RestController
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService; 
	
	@PostMapping("/purchase")
	public ResponseEntity<PurchaseResponseDto> savePurchase(@RequestBody PurchaseDto purchaseDto) throws ServiceException{
		return new ResponseEntity<>(purchaseService.savePurchase(purchaseDto), HttpStatus.OK);
	}
	
}
