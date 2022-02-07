package com.app.iservice;

import java.util.List;

import com.app.model.Product;
import com.app.pojos.ProductDTO;

public interface IProductService {
    
    public ProductDTO getProductById(String id);
    public List<ProductDTO> getAllProducts();
    public ProductDTO addProduct(ProductDTO product);
    public ProductDTO updateProduct(ProductDTO product);
    public void deleteProduct(String id);
    public List<ProductDTO> getProductsOnfo(List<String> productIds);

}
