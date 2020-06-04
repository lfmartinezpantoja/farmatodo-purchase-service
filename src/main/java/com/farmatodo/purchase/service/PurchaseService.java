package com.farmatodo.purchase.service;

import com.farmatodo.purchase.dto.PurchaseDto;
import com.farmatodo.purchase.dto.PurchaseResponseDto;
import com.farmatodo.purchase.exception.ServiceException;

public interface PurchaseService {

	public PurchaseResponseDto savePurchase(PurchaseDto purchaseDto) throws ServiceException;
}
