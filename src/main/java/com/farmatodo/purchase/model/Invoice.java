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
@Table(name = "invoices")
public class Invoice implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceNumber;
	private Long clientId;
	private Long storeId;
	private static final long serialVersionUID = -3080425232363151240L;

	
}
