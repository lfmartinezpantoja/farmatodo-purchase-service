package com.farmatodo.purchase.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.farmatodo.purchase.dto.AddProductStoreDto;
import com.farmatodo.purchase.dto.ProductStoreResponseDto;
import com.farmatodo.purchase.dto.StoreResponseDto;



@FeignClient(name = "farmatodo-service", url = "http://localhost:8090/")
public interface FarmatodoService {
	
	@GetMapping("stores/getproductbystore/{storeName}")
	public ResponseEntity<ProductStoreResponseDto> getProducts(@PathVariable String storeName);

	@PutMapping("/stores/editproduct/changequantity")
	public ResponseEntity<StoreResponseDto> editProductToStore(@RequestBody AddProductStoreDto addProductDto);
}
