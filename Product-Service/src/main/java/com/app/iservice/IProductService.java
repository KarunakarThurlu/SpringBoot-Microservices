package com.app.iservice;

import java.util.List;

import com.app.model.Product;
import com.app.pojos.ProductDTO;

public interface IProductService {
    
    public Product getProductById(String id);
    public List<Product> getAllProducts();
    public ProductDTO addProduct(ProductDTO product);
    public Product updateProduct(Product product);
    public void deleteProduct(String id);

}
