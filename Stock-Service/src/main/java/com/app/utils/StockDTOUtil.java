package com.app.utils;

import com.app.entity.Stock;
import com.app.pojos.StockDTO;

public class StockDTOUtil {


	public  static StockDTO getStockDTO(Stock stock) {
		StockDTO dto = new StockDTO();
		dto.setAmount(stock.getAmount());
		dto.setImportedDate(stock.getImportedDate());
		dto.setStockId(stock.getStockId());
		dto.setStockProducts(stock.getStockProducts());	
		return  dto;
	}
	
	public static Stock getStockEntity(StockDTO stockDTO) {
		Stock stock = new Stock();
		stock.setAmount(stockDTO.getAmount());
		stock.setImportedDate(stockDTO.getImportedDate());
		stock.setStockId(stockDTO.getStockId());
		stock.setStockProducts(stockDTO.getStockProducts());	
		return stock;
	}


}
