package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.constants.QueryConstants;
import com.app.entity.ProductStock;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock, Integer> {

	
	@Query(value = QueryConstants.GET_AVAILABLE_PRODUCTS,nativeQuery = true)
	List<String> getAvailableProducts();
}
