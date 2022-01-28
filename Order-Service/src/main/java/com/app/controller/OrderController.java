package com.app.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order")
@RestController
@RefreshScope
public class OrderController {


	@GetMapping("/foo")
	public String getMsg() {
		return "Order";
	}
}
