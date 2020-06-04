package com.farmatodo.purchase.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmatodo.purchase.model.Purchase;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
