package com.app.stockservice;

import java.util.List;

import com.app.pojos.ProductDTO;
import com.app.pojos.StockDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public interface IStockService {

	StockDTO addStock(StockDTO stockDTO);
	JsonArray getStockProducts();
}
