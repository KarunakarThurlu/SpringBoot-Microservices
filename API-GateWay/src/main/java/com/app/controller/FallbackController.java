package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ServiceDownResponse;

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
	public ServiceDownResponse stockServiceFallBack() {
		return new ServiceDownResponse(HttpStatus.SERVICE_UNAVAILABLE,"Stock service is down please try after some time Server");
	}
	
	


}
