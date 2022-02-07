package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
