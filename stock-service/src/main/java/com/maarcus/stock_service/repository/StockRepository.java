package com.maarcus.stock_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maarcus.stock_service.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
  
}
