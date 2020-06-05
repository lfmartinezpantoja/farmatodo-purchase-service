package com.farmatodo.purchase.service.imp;

import static com.farmatodo.purchase.error.Error.PRODUCT_ISNT_AVAILABLE_IN_STORE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.farmatodo.purchase.dto.AddProductStoreDto;
import com.farmatodo.purchase.dto.ClientDto;
import com.farmatodo.purchase.dto.LoginDto;
import com.farmatodo.purchase.dto.ProductPurchaseDto;
import com.farmatodo.purchase.dto.ProductStoreDto;
import com.farmatodo.purchase.dto.ProductStoreResponseDto;
import com.farmatodo.purchase.dto.PurchaseDto;
import com.farmatodo.purchase.dto.PurchaseResponseDto;
import com.farmatodo.purchase.exception.ServiceException;
import com.farmatodo.purchase.model.Invoice;
import com.farmatodo.purchase.model.Purchase;
import com.farmatodo.purchase.respository.InvoiceRepository;
import com.farmatodo.purchase.respository.PurchaseRepository;
import com.farmatodo.purchase.service.FarmatodoLoginService;
import com.farmatodo.purchase.service.FarmatodoService;
import com.farmatodo.purchase.service.PurchaseService;

import lombok.extern.java.Log;

@Log
@Service
public class PurchaseServiceImp implements PurchaseService {

	@Value("${purchase.post}")
	String purchaseMessage;

	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	FarmatodoService famatodoService;

	@Autowired
	FarmatodoLoginService loginService;

	@Override
	public PurchaseResponseDto savePurchase(PurchaseDto purchaseDto) throws ServiceException {
		Invoice invoice = new Invoice();
		ClientDto clientDto = new ClientDto();
		ProductStoreResponseDto products = new ProductStoreResponseDto();
		AddProductStoreDto updateProductDto = new AddProductStoreDto(); 
		try {
			LoginDto loginDto = new LoginDto();
			loginDto.setUsername(purchaseDto.getUsername());
			loginDto.setPassword(purchaseDto.getPassword());
			clientDto = loginService.login(loginDto).getBody();
			products = famatodoService.getProducts(purchaseDto.getStoreName()).getBody();
		}
		catch (Exception e) {
			throw new ServiceException(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		}
		boolean checkProductAndQuantity = false;
		for (int i=0; i<purchaseDto.getProducts().size(); i++) {
			for (ProductStoreDto productStore : products.getProducts()) {
				if (purchaseDto.getProducts().get(i).getProductName().equals(productStore.getProductName())
						&& purchaseDto.getProducts().get(i).getQuantity() < productStore.getQuantity()) {
					checkProductAndQuantity=true;
					purchaseDto.getProducts().get(i).setCurrentQuantity(productStore.getQuantity());
					purchaseDto.getProducts().get(i).setProductId(productStore.getProductId());
					purchaseDto.getProducts().get(i).setProductPrice(productStore.getProductPrice());
				}
			}
			if(checkProductAndQuantity==false) {
				throw new ServiceException(HttpStatus.BAD_REQUEST.value(),PRODUCT_ISNT_AVAILABLE_IN_STORE);
			}
			else {
				checkProductAndQuantity=false;
			}
		}
		
		invoice.setClientId(clientDto.getClientId());
		invoice.setStoreId(products.getStoreId());
		invoiceRepository.save(invoice);
		Long invoiceNumber = invoice.getInvoiceNumber();
		double invoicePrice = 0.0;
		for(ProductPurchaseDto productPurchaseDto :purchaseDto.getProducts()) {
			Purchase purchase = new Purchase();
			int newQuantity = productPurchaseDto.getCurrentQuantity()-productPurchaseDto.getQuantity();
			updateProductDto.setProductName(productPurchaseDto.getProductName());
			updateProductDto.setStoreName(purchaseDto.getStoreName());
			updateProductDto.setQuantity(newQuantity);
			famatodoService.editProductToStore(updateProductDto);
			purchase.setInvoiceNumber(invoiceNumber);
			purchase.setProductId(productPurchaseDto.getProductId());
			purchase.setQuantity(productPurchaseDto.getQuantity());
			purchase.setStoreId(products.getStoreId());
			purchaseRepository.save(purchase);
			invoicePrice= invoicePrice+productPurchaseDto.getProductPrice()*productPurchaseDto.getQuantity();
		}
		log.info(String.format(purchaseMessage, invoiceNumber));
		return new PurchaseResponseDto(String.format(purchaseMessage, invoiceNumber), invoiceNumber,invoicePrice);
	}

}
