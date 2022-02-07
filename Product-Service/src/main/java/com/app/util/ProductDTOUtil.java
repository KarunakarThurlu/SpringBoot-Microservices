package com.app.util;

import com.app.model.Product;
import com.app.pojos.ProductDTO;

public class ProductDTOUtil {


	public static Product getProductEntity(ProductDTO productDTO) {
		Product p = new Product();
		p.setProductId(productDTO.getProductId());
		p.setProductName(productDTO.getProductName());
		p.setProductDescription(productDTO.getProductDescription());
		p.setProductPrice(productDTO.getProductPrice());
		p.setProductBrandName(productDTO.getProductBrandName());
		p.setProductColor(productDTO.getProductColor());
		p.setProductModel(productDTO.getProductModel());
		return p;
	}
	public static ProductDTO getProductDTO(Product product) {
		ProductDTO p = new ProductDTO();
		p.setProductId(product.getProductId());
		p.setProductName(product.getProductName());
		p.setProductDescription(product.getProductDescription());
		p.setProductPrice(product.getProductPrice());
		p.setProductBrandName(product.getProductBrandName());
		p.setProductColor(product.getProductColor());
		p.setProductModel(product.getProductModel());
		return p;
	}
}
