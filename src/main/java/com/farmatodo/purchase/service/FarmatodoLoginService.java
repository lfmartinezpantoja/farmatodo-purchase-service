package com.farmatodo.purchase.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.farmatodo.purchase.dto.ClientDto;
import com.farmatodo.purchase.dto.LoginDto;



@FeignClient(name = "login-service", url = "http://localhost:9090/")
public interface FarmatodoLoginService {
	
	@GetMapping("login")
	public ResponseEntity<ClientDto> login(@RequestBody LoginDto loginDto);

}
