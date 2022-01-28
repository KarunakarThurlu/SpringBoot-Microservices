package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderService {
	
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	public static void main(String[] args) {
		log.info("Order Service is started.........");
		SpringApplication.run(OrderService.class, args);
	}
}
