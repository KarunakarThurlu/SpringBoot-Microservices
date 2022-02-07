package com.app.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

 Optional<Product> findByProductId(String productId);
}
