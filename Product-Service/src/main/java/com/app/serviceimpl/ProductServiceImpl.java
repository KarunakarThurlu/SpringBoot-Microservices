package com.app.serviceimpl;

import java.util.List;

import com.app.iservice.IProductService;
import com.app.model.Product;
import com.app.pojos.ProductDTO;
import com.app.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDTO addProduct(ProductDTO product) {
        Product p = new Product();
        p.setProductName(product.getProductName());
        p.setProductDescription(product.getProductDescription());
        p.setProductPrice(product.getProductPrice());
        Product savedProduct = productRepository.save(p);
        product.setProductId(savedProduct.getProductId());
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
    
}
