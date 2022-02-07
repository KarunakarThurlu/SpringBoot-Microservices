package com.app.utils;

import com.app.entity.ProductStock;
import com.app.pojos.ProductStockDTO;

public class ProductStockDTOUtil {

	public ProductStockDTO getProductStockDTO(ProductStock productStock) {
		ProductStockDTO dto= new ProductStockDTO();
		dto.setProductId(productStock.getProductId());
		dto.setProductStockId(productStock.getProductStockId());
		dto.setProductCount(productStock.getProductCount());
		dto.setProductSoldCount(productStock.getProductSoldCount());
		dto.setProductStatus(productStock.getProductStatus());
		return dto;
	}
	
	public ProductStock getProductStockEntity(ProductStockDTO productStockDTO) {
		ProductStock product= new ProductStock();
		product.setProductId(productStockDTO.getProductId());
		product.setProductStockId(productStockDTO.getProductStockId());
		product.setProductCount(productStockDTO.getProductCount());
		product.setProductSoldCount(productStockDTO.getProductSoldCount());
		product.setProductStatus(productStockDTO.getProductStatus());
		return product;
	}
}
