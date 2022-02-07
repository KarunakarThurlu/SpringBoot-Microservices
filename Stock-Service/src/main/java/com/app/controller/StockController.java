package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ProductDTO;
import com.app.pojos.Response;
import com.app.pojos.StockDTO;
import com.app.stockservice.IStockService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
public class StockController {

	
	@Autowired
	private IStockService stockService;
	
	
	@PostMapping("/addstock")
	public Response<StockDTO> addStock(@RequestBody StockDTO stockDTO){
		StockDTO stock= stockService.addStock(stockDTO);
		return new Response<>(stock,"Stock Added Succssfully", HttpStatus.OK);
	}
	
	@GetMapping("/availableproducts")
	public Response<JsonArray> getAvailableProducts(){
		JsonArray prds= stockService.getStockProducts();
		return new Response<>(prds,"Sccess!", HttpStatus.OK);
	}
	
}
