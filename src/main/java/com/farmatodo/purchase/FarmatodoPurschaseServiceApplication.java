package com.farmatodo.purchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FarmatodoPurschaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmatodoPurschaseServiceApplication.class, args);
	}

}
