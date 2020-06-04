package com.farmatodo.purchase.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "purchases")
public class Purchase implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseId;
	private Long productId;
	private Long storeId;
	private int quantity;
	private Long invoiceNumber;
	private static final long serialVersionUID = -3009038723012644439L;

	
}
