package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/productservicefallback")
	public String productServiceFallBack() {
		return "Product-Service is down please try after some time";
	}
	
	@GetMapping("/customerservicefallback")
	public String customerServiceFallBack() {
		return "Customer-Service is down please try after some time";
	}
	
	@GetMapping("/orderservicefallback")
	public String orderServiceFallBack() {
		return "Order-Service is down please try after some time";
	}
	
	@GetMapping("/stockservicefallback")
	public String stockServiceFallBack() {
		return "Stock-Service is down please try after some time";
	}


}
