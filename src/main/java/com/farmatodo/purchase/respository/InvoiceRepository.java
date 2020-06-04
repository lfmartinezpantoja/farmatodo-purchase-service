package com.farmatodo.purchase.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmatodo.purchase.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
